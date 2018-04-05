package View.Dashboard;

import Model.Account;
import Controller.KeyboardIn;

import java.util.Arrays;

class ExchangeMoney {
    private Account fromAccount;
    private Account toAccount;
    private int money;

    ExchangeMoney(Account account) {
        this.fromAccount = account;
        run();
    }

    private void run() {
        while (true) {
            System.out.println("请输入对方卡号：");
            int id;
            id = new KeyboardIn().run(-1);
            if (id == fromAccount.getId()) {
                System.out.println("不能给自己转账！");
                return;
            }
            toAccount = new Account(id);
            if (toAccount.get() == true) {
                break;
            } else {
                System.out.println("对方卡号输入不正确，请重试！");
            }
        }
        System.out.println("请输入转账金额：");
        money = new KeyboardIn().run(-1);
        if (money < 0) {
            System.out.println("不能存负数！");
            return;
        } else if (money == 0) {
            System.out.println("无效操作！");
            return;
        }
        if (money > fromAccount.getMoney() && fromAccount.getType() == 1) {
            System.out.println("储蓄卡用户不能透支！");
            return;
        }
        sure();
    }
    private void sure() {
        System.out.println("请确认以下信息：");
        System.out.println("对方账户：" + toAccount.getId());
        System.out.println("对方姓名：" + toAccount.getName());
        System.out.println("转账金额：" + money);
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
        if (Account.exchangeMoney(money, fromAccount, toAccount) == true) {
            System.out.println("转账成功！");
        } else {
            System.out.println("转账失败！");
        }
    }
}