package Controller.Database;

import Model.Account;
import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlAddAccount {
    private Account newAccount;

    public MysqlAddAccount(Account newAccount) {
        this.newAccount = newAccount;
    }

    public int run() {
        int id = -1;
        MysqlConnection conn = new MysqlConnection();
        try {
            String sql = "INSERT INTO bank VALUES (null, '" + newAccount.getName()
                    + "', '" + newAccount.getPassword() + "', " + newAccount.getMoney()
                    + ", " + newAccount.getType() + ");";
            conn.Mysqlupdate(sql);
            sql = "select auto_increment - 1 AS id "
                    + "from information_schema.tables "
                    + "where table_schema='jdbc' and table_name='bank';";
            ResultSet rs = conn.Mysqlquery(sql);
            if (rs.next())
                id = rs.getInt("id");
        } catch (MysqlConnectionError error) {
//            System.out.println("数据库连接失败！");
            return -1;
        } catch (SQLException error) {
//            error.printStackTrace();
//            System.out.println("添加账户信息执行失败！");
            return -1;
        }
        try {
            conn.Mysqlclose();
        } catch (MysqlCloseError error) {
//            System.out.println("数据库断开失败！");
            return -1;
        }
//        System.out.println("添加账户信息成功！");
        return id;
    }
}
