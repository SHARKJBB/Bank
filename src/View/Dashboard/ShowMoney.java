package View.Dashboard;

import Model.Account;

class ShowMoney {
    private Account account;
    ShowMoney(Account account) {
        this.account = account;
        run();
    }

    private void run() {
        System.out.println("您的余额为：" + account.getMoney());
    }
}
