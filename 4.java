import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        char[][] array = {
                {'2', '*', '(', '1', '+', '2', ')', '/', '3', '=', '2'},
                {'3', '*', '(', '4', '+', '5', ')', '/', '9', '=', '3'},
                {'2', '*', '(', '6', '+', '7', ')', '/', '4', '=', '8'},
                {'3', '*', '(', '8', '+', '9', ')', '/', '6', '=', '5'}
        };
        Pattern pattern = Pattern.compile("([23])\\*\\((\\d+)\\+(\\d+)\\)\\/(\\d+)=(\\d+)");
        int cnt = 0;
        ArrayList<String> incorrect = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < array[i].length; j++) {
                row.append(array[i][j]);
            }
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                String exp = matcher.group();
                System.out.println("Найдено выражение по строке: " + exp);
                if (check(matcher)) {
                    cnt++;
                } else {
                    incorrect.add(exp);
                }
            }
        }
        for (int j = 0; j < array[0].length; j++) {
            StringBuilder column = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                column.append(array[i][j]);
            }
            Matcher matcher = pattern.matcher(column);
            while (matcher.find()) {
                String exp = matcher.group();
                System.out.println("Найдено выражение по столбцу: " + exp);
                if (check(matcher)) {
                    cnt++;
                } else {
                    incorrect.add(exp);
                }
            }
        }
        System.out.println("Количество правильно вычисленных выражений: " + cnt);
        System.out.println("Неправильно вычисленные выражения с корректировкой ответа:");
        for (String exp : incorrect) {
            System.out.println(exp);
        }
    }
    private static boolean check(Matcher matcher) {
        int m = Integer.parseInt(matcher.group(1));
        int num1 = Integer.parseInt(matcher.group(2));
        int num2 = Integer.parseInt(matcher.group(3));
        int d = Integer.parseInt(matcher.group(4));
        int res = Integer.parseInt(matcher.group(5));
        return m * (num1 + num2) / d == res;
    }
}
