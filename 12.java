import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("жыраф шыповник аааааа буквы  пробелы");
        array.add("жыр шылык ббббб  много  пробелов");
        for (String strIn : array) {
            String str = correct(strIn);
            System.out.println("Исходная строка: " + strIn);
            System.out.println("Исправленная строка: " + str);
            System.out.println();
        }
    }
    public static String correct(String inputString) {
        String str = inputString.replaceAll("жы", "жи");
        str = str.replaceAll("шы", "ши");
        str = str.replaceAll("(.)\\1{2,}", "$1$1");
        str = str.replaceAll("\\s{2,}", " ");
        return str;
    }
}
