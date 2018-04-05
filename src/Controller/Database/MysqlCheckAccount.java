package Controller.Database;

import Model.Account;
import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlCheckAccount {
    private Account account;
    public MysqlCheckAccount(Account account) {
        this.account = account;
    }

    public void run() {
        MysqlConnection conn = new MysqlConnection();
        try {
            String sql = "SELECT * FROM bank WHERE id = " + account.getId();
            ResultSet rs = conn.Mysqlquery(sql);
            if (rs.next()) {
                account.setName(rs.getString("name"));
                account.setMoney(rs.getInt("money"));
                account.setType(rs.getInt("type"));
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
