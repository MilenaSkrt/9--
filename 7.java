class Main{
    public static void main(String[] args) {
        String str = "1 2 3 4 5 6 ";
        String reversed = reverseWords(str);
        System.out.println(reversed);
    }
    public static String reverseWords(String str) {
        String[] array = str.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            reversed.append(array[i]).append(" ");
        }
        return reversed.toString().trim();
    }
}
