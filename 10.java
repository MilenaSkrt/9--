import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Школьник: Иванов; Иван; Иванович; м; русский; 150; 45; 2008-05-12; 89129512345; 123456, Россия, Москва, Центральный, Москва, Тверская, 1, 1; 1; 5." +
                "Школьник: Петров; Петр; Петрович; м; русский; 160; 50; 2008-06-13; 89129123595; 654321, Россия, Москва, Западный, Москва, Арбат, 2, 2; 2; 5.";
        List<String> array = splitData(text);
        int cnt = cntNum(array, "912|919", 5);
        System.out.println("Количество людей с номерами, содержащими 912 или 919 и заканчивающимися на 5: " + cnt);
        System.out.println("Сведения про всех учеников пятых классов:");
        print(array, 5);
    }

    public static List<String> splitData(String text) {
        String[] objects = text.split("\\.");
        return new ArrayList<>(Arrays.asList(objects));
    }

    public static int cntNum(List<String> array, String str, int a) {
        int cnt = 0;
        Pattern pattern1 = Pattern.compile(str);
        for (String student : array) {
            String[] data = student.split(";");
            String phoneNum = data[8].trim();
            Matcher matcher = pattern1.matcher(phoneNum);
            if (matcher.find() && phoneNum.charAt(phoneNum.length() - 1) == (char) (a + '0')) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void print(List<String> array, int a) {
        for (String student : array) {
            String[] data = student.split(";");
            int studentGrade = Integer.parseInt(data[11].trim());
            if (studentGrade == a) {
                System.out.println(student);
            }
        }
    }
}
