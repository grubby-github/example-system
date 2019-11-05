using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dapper;
using MySql.Data.MySqlClient;

namespace WindowsFormsApplication1
{
    public class ImportExcel
    {
        //private string connStr = "server=192.168.1.172;port=3306;user=root;password=123456;database=ivs007web(v1_2_3)quanzhou;convert zero datetime=True;pooling=true;";
        private string connStr = "server=10.229.160.98;port=3306;user=root;password=123456;database=ivs007web(v1_2_3)quanzhou;convert zero datetime=True;pooling=true;";

        public void Import()
        {
            DataSet data = this.ExcelToDS("案件类别.xls");
            long index = 100000;
            foreach (System.Data.DataRow row in data.Tables[0].Rows)
            {
                string typeName = row.ItemArray[2] as string;
                string typeDescription = row.ItemArray[3] as string;
                string sql = string.Format("select count(*) from datatypemappers where TypeID = 'Base.DataAccess.CaseType' and TypeName = '{0}'", typeName);
                int total = Convert.ToInt32(MySqlHelper.ExecuteScalar(connStr, sql).ToString());
                if (total < 1)
                {
                    DataTypeMapper temp = new DataTypeMapper();
                    temp.TypeDescription = typeDescription;
                    temp.TypeID = "Base.DataAccess.CaseType";
                    temp.TypeName = typeName;
                    temp.TypeValue = index++;
                    temp.UpdatedTime = temp.CreatedTime = DateTime.Now;
                    temp.UpdatedUser = temp.CreatedUser = "admin";
                    temp.IsSystemValue = false;
                    this.CreateDataTypeMapper(temp);
                }
            }
        }

        private void CreateDataTypeMapper(DataTypeMapper dataType)
        {
            string sql = "INSERT INTO DataTypeMappers (TypeValue, TypeName, TypeDescription, TypeID, IsSystemValue, CreatedUser, CreatedTime, UpdatedUser, UpdatedTime) VALUES (@TypeValue, @TypeName, @TypeDescription, @TypeID, @IsSystemValue, @CreatedUser, @CreatedTime, @UpdatedUser, @UpdatedTime );";
            using (IDbConnection conn = OpenConnection())
            {
                int id = conn.ExecuteScalar<int>(sql, dataType);
            }
        }

        private DataSet ExcelToDS(string Path)
        {
            string strConn = "Provider=Microsoft.Jet.OLEDB.4.0;" + "Data Source=" + Path + ";" + "Extended Properties=Excel 8.0;";
            OleDbConnection conn = new OleDbConnection(strConn);
            conn.Open();
            string strExcel = "";
            OleDbDataAdapter myCommand = null;
            DataSet ds = null;
            strExcel = "select * from [SQL Results$]";
            myCommand = new OleDbDataAdapter(strExcel, strConn);
            ds = new DataSet();
            myCommand.Fill(ds, "table1");
            return ds;
        }

        private IDbConnection OpenConnection()
        {
            return new MySqlConnection(connStr);
        }
    }

    public class DataTypeMapper
    {
        public int ID { get; set; }

        public long TypeValue { get; set; }

        public string TypeName { get; set; }

        public string TypeDescription { get; set; }

        public string TypeID { get; set; }

        public bool IsSystemValue { get; set; }

        public string CreatedUser { get; set; }

        public DateTime CreatedTime { get; set; }

        public string UpdatedUser { get; set; }

        public DateTime UpdatedTime { get; set; }
    }
}
