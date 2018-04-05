package View.Dashboard;

import Model.Account;
import Controller.KeyboardIn;

import java.util.Arrays;

public class Welcome {
    private int anInt;
    private Account account;

    public Welcome(Account account) {
        this.account = account;
        run();
    }

    private void run() {
        System.out.println("-----------------------------");
        System.out.println("您好，" + account.getName());
        if (account.getType() == 1) {
            System.out.println("您是储蓄卡用户");
        } else {
            System.out.println("您是信用卡用户");
        }
        System.out.println("请选择服务：");
        System.out.println("1.查余额");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.转账");
        System.out.println("0.退出");
        System.out.println("-----------------------------");
        anInt = new KeyboardIn().run(Arrays.asList(0, 1, 2, 3, 4));
        next();
    }

    private void next() {
        switch (anInt) {
            case 1:
                new ShowMoney(account);
                break;
            case 2:
                new InMoney(account);
                break;
            case 3:
                new OutMoney(account);
                break;
            case 4:
                new ExchangeMoney(account);
                break;
            case 0:
                return;
        }
        run();
    }
}
