package Controller.Database;

import Model.Account;
import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlLoginAccount {
    private Account loginAccount;

    public MysqlLoginAccount(Account loginAccount) {
        this.loginAccount = loginAccount;
    }

    public void run() {
        MysqlConnection conn = new MysqlConnection();
        try {
            String sql = "SELECT * FROM bank WHERE id = " + loginAccount.getId();
            ResultSet rs = conn.Mysqlquery(sql);
            if (rs.next()) {
                loginAccount.setPassword(rs.getString("password"));
                loginAccount.setName(rs.getString("name"));
                loginAccount.setMoney(rs.getInt("money"));
                loginAccount.setType(rs.getInt("type"));
            }
        } catch (MysqlConnectionError error) {
//            System.out.println("数据库连接失败！");
            return;
        } catch (SQLException error) {
//            error.printStackTrace();
//            System.out.println("查询账户信息执行失败！");
            return;
        }
        try {
            conn.Mysqlclose();
        } catch (MysqlCloseError error) {
//            System.out.println("数据库断开失败！");
            return;
        }
//        System.out.println("查询账户信息成功！");
    }
}
