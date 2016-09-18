import java.util.List;

public class Main {

    public static void main(String[] args) {
        PhoneNumberLetter solution = new PhoneNumberLetter();
        List<String> strings = solution.letterCombinations("2");
        strings.forEach(System.out::println);
    }
}
