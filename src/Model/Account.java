package Model;

import Controller.Database.MysqlAddAccount;
import Controller.Database.MysqlChangeMoney;
import Controller.Database.MysqlCheckAccount;
import Controller.Database.MysqlLoginAccount;

public class Account {
    private String name;
    private String password;
    private int id;
    private int money;
    private int type;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getMoney() {
        return money;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setType(int type) {
        this.type = type;
    }

    // MysqlAddAccount:
    public Account(int type, String name, String password) {
        this.name = name;
        this.password = password;
        this.id = -1;
        this.money = 0;
        this.type = type;
    }

    // MysqlLoginAccount:
    public Account(int id, String password) {
        this.password = password;
        this.id = id;
        this.type = -1;
    }

    // ExchangeMoney fromAccount:
    public Account(int id) {
        this.id = id;
    }

    public boolean add() {
        id = new MysqlAddAccount(this).run();
        if (id != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean login() {
        String inPassword = password;
        new MysqlLoginAccount(this).run();
        if (type != -1 && password.equals(inPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inMoney(int in) {
        money += in;
        if (new MysqlChangeMoney(this).run() == true) {
            return true;
        } else {
            money -= in;
            return false;
        }
    }

    public boolean outMoney(int out) {
        money -= out;
        if (new MysqlChangeMoney(this).run() == true) {
            return true;
        } else {
            money += out;
            return false;
        }
    }

    public boolean get() {
        type = -1;
        new MysqlCheckAccount(this).run();
        if (type != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean exchangeMoney(int money, Account fromAccount, Account toAccount) {
        if (fromAccount.outMoney(money) == true) {
            if (toAccount.inMoney(money) == true) {
                return true;
            }
        }
        return false;
    }
}
