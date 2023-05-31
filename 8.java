public class Main {
    public static void main(String[] args) {
        String str = "hellowoooorld";
        String compressed = compress(str);
        System.out.println(compressed);
    }
    public static String compress(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                stringBuilder.append(str.charAt(i));
                if (cnt > 1) {
                    stringBuilder.append(cnt);
                }
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return stringBuilder.toString();
    }

}
