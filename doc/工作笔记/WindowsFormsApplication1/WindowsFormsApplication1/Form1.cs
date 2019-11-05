using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Dapper;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        private Timer _timer;
        public Form1()
        {
            InitializeComponent();
            //this._timer = new Timer();
            //this._timer.Interval = 1 * 1000;
            //this._timer.Tick += _timer_Tick;
            //this._timer.Start();

            //string url = "http://192.168.1.172:8080/base-web-1.0.0/alarmrecevice/recevice";
            //string msg = "{\"id\":302,\"method\":\"alarm\"}";
            //for (int i = 0; i < 10000; i++)
            //{
            //    Console.WriteLine("=================>>>>" + i + " | " + this.HTTPPost4Resp(url, msg));
            //}

            ImportExcel importExcel = new ImportExcel();
            importExcel.Import();
        }

        void _timer_Tick(object sender, EventArgs e)
        {
            DateTime ss = DateTime.Parse("2019-08-16 20:00:00");
            DateTime now = DateTime.Now;
            TimeSpan dd = now - ss;

            this.label2.Text = dd.Days + "天" + dd.Hours + "时" + dd.Minutes + "分" + dd.Seconds + "秒";
            DateTime? test = DateTime.Now;
            Console.WriteLine(test.Value.ToShortDateString() + test.Value.ToShortTimeString());
        }

        public string HTTPPost4Resp(string url, string msg)
        {
            string result = string.Empty;
            System.IO.StreamReader reader = null;
            try
            {
                byte[] data = Encoding.UTF8.GetBytes(msg);
                HttpWebRequest request = WebRequest.Create(url) as HttpWebRequest;
                request.ContentType = "application/json";
                request.ContentLength = data.LongLength;
                request.Method = "POST";
                request.Timeout = 15 * 1000;
                using (Stream reqStream = request.GetRequestStream())
                {
                    reqStream.Write(data, 0, (int)data.Length);
                }
                using (HttpWebResponse resp = request.GetResponse() as HttpWebResponse)
                {
                    using (Stream respStream = resp.GetResponseStream())
                    {
                        reader = new System.IO.StreamReader(respStream, Encoding.UTF8);
                        result = reader.ReadToEnd();
                    }
                }
            }
            catch (Exception ex)
            {
            }
            finally
            {
                if (reader != null)
                {
                    reader.Close();
                    reader.Dispose();
                    reader = null;
                }
            }
            return result;
        }
    }
}
