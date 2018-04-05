package View.Dashboard;

import Model.Account;
import Controller.KeyboardIn;

class OutMoney {
    private Account account;

    OutMoney(Account account) {
        this.account = account;
        run();
    }

    private void run() {
        System.out.println("请输入您要取款的金额：");
        int anInt = new KeyboardIn().run(-1);
        if (anInt <= 0) {
            System.out.println("不能取负数！");
            return;
        }
        if (anInt > account.getMoney() && account.getType() == 1) {
            System.out.println("储蓄卡用户不能透支！");
            return;
        } else if (anInt == 0) {
            System.out.println("无效操作！");
            return;
        }
        if (account.outMoney(anInt) == true) {
            System.out.println("取款成功！");
            System.out.println("取出金额：" + anInt);
        } else {
            System.out.println("取款失败！");
        }
    }
}
