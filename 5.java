import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "one one two two five five five ";
        String[] words = str.toLowerCase().split("\\W+");
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            if (cnt.containsKey(word)) {
                cnt.put(word, cnt.get(word) + 1);
            } else {
                cnt.put(word, 1);
            }
        }
        String odd = null;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd = entry.getKey();
                break;
            }
        }
        System.out.println("Слово, которое встречается нечетное количество раз: " + odd);
    }
}
