package cn.gaoz.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class HTTPUtil {
    //region properties

    private boolean isHTTPS;
    private String contentType;
    private SSLSocketFactory SSLSocketFactory;
    //private String HTTPHeader;
    private Logger logger = LoggerFactory.getLogger(HTTPUtil.class);
    private final String METHOD_GET = "GET";
    private final String ENCODING = "UTF-8";

    public static final String CONTENTTYPE_XML = "application/xml";
    public static final String CONTENTTYPE_JSON = "application/json";

    //endregion

    //region constructor

    public HTTPUtil(boolean isHTTPS, String contentType) {
        this.isHTTPS = isHTTPS;
        this.contentType = contentType;
        if (this.isHTTPS) {
            TrustManager[] tm = {new HTTPSX509TrustManager()};
            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                sslContext.init(null, tm, new java.security.SecureRandom());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            this.SSLSocketFactory = sslContext.getSocketFactory();
        }
    }

    //endregion

    //region public methods

    public String sendRequestGet(String url) {
        return this.sendRequest(url, this.METHOD_GET, null);
    }

    public String sendRequestPost(String url, String message) {
        return this.sendRequest(url, "POST", message);
    }

    public String sendRequestPut(String url, String message) {
        return this.sendRequest(url, "PUT", message);
    }

    public String sendRequestDelete(String url, String message) {
        return this.sendRequest(url, "DELETE", message);
    }

    public String sendRequestPatch(String url, String message) {
        return this.sendRequest(url, "PATCH", message);
    }

    //endregion

    //region private methods

    private String sendRequest(String url, String method, String message) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        String result = null;
        try {
            this.logger.warn("Url:{}", url);
            this.logger.warn("Request:{}", message);
            URL httpUrl = new URL(url);
            connection = (HttpURLConnection) httpUrl.openConnection();
            if (this.isHTTPS) {
                //设置https访问的证书问题
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
                httpsURLConnection.setHostnameVerifier(new HTTPSHostnameVerifier());
                httpsURLConnection.setSSLSocketFactory(this.SSLSocketFactory);
            }
            connection.setRequestMethod(method);
            connection.setRequestProperty("Content-Type", this.contentType);
            connection.setRequestProperty("Charset", this.ENCODING);
//            if (!stringUtil.isEmpty(this.HTTPHeader)) {
//                HttpsURLConnection.setRequestProperty("Cookie", this.HTTPHeader);
//            }
            if (method.equals(this.METHOD_GET)) {
                connection.connect();
            } else {
                connection.setDoOutput(true);
                connection.setDoInput(true);
                outputStream = connection.getOutputStream();
                if (message != null) {
                    outputStream.write(message.getBytes(Charset.forName(this.ENCODING)));
                }
            }
            if (connection.getResponseCode() == 200) {
//                List<String> tempCookieList = connection.getHeaderFields().get("Set-Cookie");
//                if (ListUtil.isNotEmpty(tempCookieList)) {
//                    this.HTTPHeader = tempCookieList.get(0);
//                }
                inputStream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, this.ENCODING));
                StringBuffer stringBuffer = new StringBuffer();
                String temp = null;
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuffer.append(temp);
                    stringBuffer.append("\r\n");
                }
                result = stringBuffer.toString();
            }
        } catch (Exception e) {
            this.logger.error("sendRequest 异常", e);
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();
        }
        this.logger.warn("Response:{}", result);
        return result;
    }

    //endregion

}
