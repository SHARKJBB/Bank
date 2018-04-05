package View;

import Model.Account;
import Controller.KeyboardIn;

import java.util.Arrays;

public class AddAccount {
    private int type;
    private String name;
    private String password;

    public AddAccount() {
        run();
    }

    private void run() {
        System.out.println("请按要求输入开户信息：");
        System.out.println("银行卡类型：");
        System.out.println("1.储蓄卡 2.信用卡");
        type = new KeyboardIn().run(Arrays.asList(1, 2));
        System.out.println("姓名：");
        name = new KeyboardIn().run();
        System.out.println("密码：");
        password = new KeyboardIn().run();
        sure();
    }

    private void sure() {
        System.out.println("请确认以下信息：");
        switch (type) {
            case 1:
                System.out.println("种类：储蓄卡");
                break;
            case 2:
                System.out.println("种类：信用卡");
                break;
        }
        System.out.println("姓名：" + name);
        System.out.println("密码：" + password);
        System.out.println("1.确定 2.重新输入 0.退出");
        switch (new KeyboardIn().run(Arrays.asList(0, 1, 2))) {
            case 1:
                next();
                break;
            case 2:
                run();
                break;
            case 0:
                return;
        }
    }

    private void next() {
        Account newAccount = new Account(type, name, password);
        if (newAccount.add() == true) {
            System.out.println("开户成功！");
            System.out.println("卡号：" + newAccount.getId());
        } else {
            System.out.println("开户失败！");
            System.out.println("1.重新输入开户信息 0.退出");
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
