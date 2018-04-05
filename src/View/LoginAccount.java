package View;

import Model.Account;
import Controller.KeyboardIn;
import View.Dashboard.Welcome;

import java.util.Arrays;

public class LoginAccount {
    private int id;
    private String password;

    public LoginAccount() {
        run();
    }

    private void run() {
        System.out.println("请按要求输入登录信息：");
        System.out.println("卡号：");
        id = new KeyboardIn().run(-1);
        System.out.println("密码：");
        password = new KeyboardIn().run();
        next();
    }

    private void next() {
        Account loginAccount = new Account(id, password);
        if (loginAccount.login() == true) {
            System.out.println("登录成功！");
            new Welcome(loginAccount);
        } else {
            System.out.println("登录失败！");
            System.out.println("1.重新输入登录信息 0.退出");
            switch (new KeyboardIn().run(Arrays.asList(0, 1))) {
                case 1:
                    run();
                    break;
                case 0:
                    return;
            }
        }
    }
}
