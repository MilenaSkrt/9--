import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] inputArray = new char[11];
        System.out.println("Введите массив символов из 11 элементов:");
        for (int i = 0; i < 11; i++) {
            inputArray[i] = in.next().charAt(0);
        }
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = Character.toUpperCase(inputArray[i]);
        }
        System.out.println("Массив символов после преобразования:");
        for (char c : inputArray) {
            System.out.print(c + " ");
        }
    }
}
