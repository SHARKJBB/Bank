package View.Dashboard;

import Model.Account;
import Controller.KeyboardIn;

class InMoney {
    private Account account;

    InMoney(Account account) {
        this.account = account;
        run();
    }

    private void run() {
        System.out.println("请输入您要存款的金额：");
        int anInt = new KeyboardIn().run(-1);
        if (anInt < 0) {
            System.out.println("不能存负数！");
            return;
        } else if (anInt == 0) {
            System.out.println("无效操作！");
            return;
        }
        if (account.inMoney(anInt) == true) {
            System.out.println("存款成功！");
        } else {
            System.out.println("存款失败！");
            System.out.println("退回金额：" + anInt);
        }
    }
}
