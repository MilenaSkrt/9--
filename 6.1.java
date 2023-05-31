import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] array = new String[2];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите информацию о семье №" + (i + 1) + ":");
            System.out.print("Фамилия: ");
            String surname = in.nextLine();
            System.out.print("Район, где живут: ");
            String district = in.nextLine();
            System.out.print("Полная/Неполная семья: ");
            String type = in.nextLine();
            System.out.print("Количество членов семьи: ");
            int members = in.nextInt();
            in.nextLine(); 
            System.out.print("Количество детей: ");
            int children = in.nextInt();
            in.nextLine(); 
            System.out.print("Количество комнат в жилье: ");
            int rooms = in.nextInt();
            in.nextLine(); 
            System.out.print("Квадратные метры жилья: ");
            int area = in.nextInt();
            in.nextLine();
            System.out.print("Доход на одного члена семьи: ");
            int income = in.nextInt();
            in.nextLine();
            System.out.print("Наличие компьютеров (да/нет): ");
            boolean hasComputer = in.nextLine().equalsIgnoreCase("да");
            int computers = 0;
            if (hasComputer) {
                System.out.print("Количество компьютеров: ");
                computers = in.nextInt();
                in.nextLine();
            }
            System.out.print("Наличие домашних животных (да/нет): ");
            boolean hasPets = in.nextLine().equalsIgnoreCase("да");
            int pets = 0;
            if (hasPets) {
                System.out.print("Количество домашних животных: ");
                pets = in.nextInt();
                in.nextLine();
            }
            array[i] = surname + ";" + district + ";" + type + ";" + members + ";" + children + ";" + rooms + ";" + area + ";" + income + ";" + hasComputer + ";" + computers + ";" + hasPets + ";" + pets;
        }
        int[] poorFamiliesByDistrict = new int[5];
        for (String family : array) {
            String[] fields = family.split(";");
            String district = fields[1];
            String type = fields[2];
            int income = Integer.parseInt(fields[7]);
            int members = Integer.parseInt(fields[3]);
            if (type.equalsIgnoreCase("неполная") && income / members < 10000) {
                switch (district) {
                    case "Центр":
                        poorFamiliesByDistrict[0]++;
                        break;
                    case "Север":
                        poorFamiliesByDistrict[1]++;
                        break;
                    case "Юг":
                        poorFamiliesByDistrict[2]++;
                        break;
                    case "Запад":
                        poorFamiliesByDistrict[3]++;
                        break;
                    case "Восток":
                        poorFamiliesByDistrict[4]++;
                        break;
                }
            }
        }
        System.out.println("Количество неполных семей по районам с доходом на одного члена семьи ниже, чем прожиточный минимум:");
        System.out.println("Центр: " + poorFamiliesByDistrict[0]);
        System.out.println("Север: " + poorFamiliesByDistrict[1]);
        System.out.println("Юг: " + poorFamiliesByDistrict[2]);
        System.out.println("Запад: " + poorFamiliesByDistrict[3]);
        System.out.println("Восток: " + poorFamiliesByDistrict[4]);
        int cnt= 0;
        for (String str : array) {
            String[] field = str.split(";");
            String type = field[2];
            boolean hasComputer = Boolean.parseBoolean(field[8]);
            if (type.equalsIgnoreCase("неполная") && hasComputer) {
                cnt++;
            }
        }
        System.out.println("Количество неполных семей, в которых есть хотя бы один компьютер: " + cnt
    }
}
