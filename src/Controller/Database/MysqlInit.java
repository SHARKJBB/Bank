package Controller.Database;

import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.SQLException;

public class MysqlInit {
    public MysqlInit() {
        MysqlConnection conn = new MysqlConnection();
        try {
            String sql = "CREATE TABLE bank (\n" +
                    "  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,\n" +
                    "  name VARCHAR(20) NOT NULL,\n" +
                    "  password VARCHAR(20) NOT NULL,\n" +
                    "  money INT NOT NULL,\n" +
                    "  type INT NOT NULL\n" +
                    ");";
            conn.Mysqlupdate(sql);
            sql = "ALTER TABLE bank AUTO_INCREMENT = " + 10000;
            conn.Mysqlupdate(sql);
        } catch (MysqlConnectionError error) {
            System.out.println("数据库连接失败！");
            return;
        } catch (SQLException error) {
            // error.printStackTrace();
            System.out.println("初始化执行失败！");
            return;
        }
        try {
            conn.Mysqlclose();
        } catch (MysqlCloseError error) {
            System.out.println("数据库断开失败！");
            return;
        }
        System.out.println("初始化成功！");
    }

    public static void main(String[] args) {
        new MysqlInit();
    }
}
