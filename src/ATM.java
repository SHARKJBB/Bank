import Controller.Database.MysqlInit;
import Controller.KeyboardIn;
import View.Start;

import java.util.Arrays;

public class ATM {
    public static void main(String[] args) {
        System.out.println("Loading ...");
        System.out.println("0.初始化数据库");
        System.out.println("1.开启ATM");
        int anInt = new KeyboardIn().run(Arrays.asList(0, 1, 2));
        switch (anInt) {
            case 0:
                new MysqlInit();
                break;
            case 1:
                new Start();
                break;
        }
    }
}