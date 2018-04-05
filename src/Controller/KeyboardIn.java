package Controller;

import Model.Exception.OverLimit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class KeyboardIn {
    public KeyboardIn() {
        System.out.print("请输入：");
    }

    public int run(List<Integer> limit) {
        int anInt = -1;
        while (anInt == -1) {
            try {
                anInt = new Scanner(System.in).nextInt();
                if (limit.size() > 0) {
                    if (limit.contains(anInt) == false) {
                        throw new OverLimit();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("输入不正确，请重新输入！");
            } catch (OverLimit overLimit) {
                System.out.println("输入不在正确范围，请重新输入！");
                anInt = -1;
            }
        }
        return anInt;
    }

    public int run(int anInt) {
        while (anInt == -1) {
            try {
                anInt = new Scanner(System.in).nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("输入不正确，请重新输入！");
            }
        }
        return anInt;
    }

    public String run() {
        return new Scanner(System.in).nextLine();
    }
}
