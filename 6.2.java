import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> array = new ArrayList<>();
        System.out.println("Введите информацию о семьях (для завершения ввода введите пустую строку):");
        while (true) {
            String str = in.nextLine();
            if (str.isEmpty()) {
                break;
            }
            array.add(str);
        }
        int[] poor = new int[5];
        for (String str : array) {
            String[] field = str.split(";");
            String district = field[1];
            String type = field[2];
            int income = Integer.parseInt(field[7]);
            int members = Integer.parseInt(field[3]);
            if (type.equalsIgnoreCase("неполная") && income / members < 10000) {
                switch (district) {
                    case "Центр":
                        poor[0]++;
                        break;
                    case "Север":
                        poor[1]++;
                        break;
                    case "Юг":
                        poor[2]++;
                        break;
                    case "Запад":
                        poor[3]++;
                        break;
                    case "Восток":
                        poor[4]++;
                        break;
                }
            }
        }
        System.out.println("Количество неполных семей по районам с доходом на одного члена семьи ниже, чем прожиточный минимум:");
        System.out.println("Центр: " + poor[0]);
        System.out.println("Север: " + poor[1]);
        System.out.println("Юг: " + poor[2]);
        System.out.println("Запад: " + poor[3]);
        System.out.println("Восток: " + poor[4]);
        int cnt = 0;
        for (String family : array) {
            String[] fields = family.split(";");
            String type = fields[2];
            boolean hasComputer = Boolean.parseBoolean(fields[8]);
            if (type.equalsIgnoreCase("неполная") && hasComputer) {
                cnt++;
            }
        }
        System.out.println("Количество неполных семей, в которых есть хотя бы один компьютер: " + cnt);
    }
}
