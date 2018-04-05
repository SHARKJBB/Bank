package Controller.Database;

import Model.Account;
import Model.Exception.MysqlCloseError;
import Model.Exception.MysqlConnectionError;

import java.sql.SQLException;

public class MysqlChangeMoney {
    private Account account;

    public MysqlChangeMoney(Account account) {
        this.account = account;
    }

    public boolean run() {
        MysqlConnection conn = new MysqlConnection();
        try {
            String sql = "UPDATE bank SET money = " + account.getMoney() + " WHERE id = " + account.getId() + ";";
            conn.Mysqlupdate(sql);
        } catch (MysqlConnectionError error) {
//            System.out.println("数据库连接失败！");
            return false;
        } catch (SQLException error) {
//            error.printStackTrace();
//            System.out.println("更新余额信息执行失败！");
            return false;
        }
        try {
            conn.Mysqlclose();
        } catch (MysqlCloseError error) {
//            System.out.println("数据库断开失败！");
            return false;
        }
//        System.out.println("更新余额信息成功！");
        return true;
    }
}
