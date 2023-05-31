import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num;
        boolean flag;
        do {
            System.out.println("Введите число в десятичной системе счисления:");
            num = in.nextLine();
            flag = num.matches("[0-9]+");

            if (!flag) {
                System.out.println("Введено неверное число. Пожалуйста, введите число, содержащее только символы 0-9.");
            }
        } while (!flag);
        int decimal = Integer.parseInt(num);
        String binary = Integer.toBinaryString(decimal);
        char[] binaryArray = binary.toCharArray();
        System.out.println("Число в двоичной системе счисления:");
        for (char c : binaryArray) {
            System.out.print(c);
        }
    }
}
