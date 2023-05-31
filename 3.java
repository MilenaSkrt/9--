import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите массив символов:");
        String str = in.nextLine();
        char[] array = str.toCharArray();
        int cnt = 0;
        for (char c : array) {
            if (Character.isDigit(c)) {
                cnt++;
            }
        }
        System.out.println("Количество цифр: " + cnt);
        System.out.println("Введите символ для проверки:");
        char s = in.next().charAt(0);
        int cnt1 = 0;
        for (char c : array) {
            if (c == s) {
                cnt1++;
            }
        }
        System.out.println("Символ " + s + " входит " + cnt1 + " раз.");
        System.out.println("Введите число для проверки:");
        String num = in.next();
        boolean flag = true;
        for (char digit : num.toCharArray()) {
            if (!str.contains(Character.toString(digit))) {
                flag = false;
                break;
            }
        }
        System.out.println("Все цифры из числа " + num + " присутствуют: " + flag);
        boolean flag1 = false;
        Stack<Character> brackets = new Stack<>();
        for (char c : array) {
            if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
                if (!brackets.isEmpty() && Pair(brackets.peek(), c)) {
                    brackets.pop();
                } else {
                    brackets.push(c);
                }
            }
        }
        flag1 = brackets.isEmpty();
        System.out.println("Имеются закрытые пары разного сочетания: " + flag1);
        String str1 = ".,;:!?";
        boolean flag2 = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (str1.contains(Character.toString(array[i])) && array[i] == array[i + 1]) {
                flag2 = true;
                break;
            }
        }
        System.out.println("Имеются соседствующие одинаковые символы, относящиеся к знакам препинания: " + flag2);
        boolean flag3 = false;
        for (int i = 0; i < array.length - 3; i++) {
            if (Character.isDigit(array[i]) && Character.isDigit(array[i + 1]) && Character.isDigit(array[i + 2]) && Character.isDigit(array[i + 3])) {
                if (array[i] < array[i + 1] && array[i + 2] > array[i + 3]) {
                    flag3 = true;
                    break;
                }
            }
        }
        System.out.println("Существуют i и j, что si и si+1 возрастающая последовательность цифр, а sj и sj+1 убывающая последовательность цифр: " + flag3);
    }
    private static boolean Pair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
