package View;

import Controller.KeyboardIn;

import java.util.Arrays;

public class Start {
    private int anInt;

    public Start() {
        run();
    }

    private void run() {
        System.out.println("=============================");
        System.out.println("欢迎使用虚拟银行ATM！");
        System.out.println("请选择服务：");
        System.out.println("1.无卡开户");
        System.out.println("2.插卡登录");
        System.out.println("0.退出");
        System.out.println("=============================");
        anInt = new KeyboardIn().run(Arrays.asList(0, 1, 2));
        next();
    }

    private void next() {
        switch (anInt) {
            case 1:
                new AddAccount();
                break;
            case 2:
                new LoginAccount();
                break;
            case 0:
                System.out.println("欢迎下次使用虚拟银行ATM！");
                return;
        }
        run();
    }
}
