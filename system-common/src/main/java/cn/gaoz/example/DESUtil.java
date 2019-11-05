package cn.gaoz.example;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

public class DESUtil {
    private Key key;
    private final String DES = "DES";

    public DESUtil(byte[] strKey) {
        try {
            DESKeySpec dks = new DESKeySpec(strKey);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(this.DES);
            key = keyFactory.generateSecret(dks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     *
     * @param byteS
     * @return
     */
    public byte[] encrypt(byte[] byteS) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(this.DES);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteFina;
    }

    /**
     * 解密
     *
     * @param byteD
     * @return
     */
    public byte[] decrypt(byte[] byteD) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance(this.DES);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteFina;
    }
}