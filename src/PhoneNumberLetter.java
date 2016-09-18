import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneNumberLetter {
    private final Map<Character, String> combination = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return getStrings(digits);
        }
        List<String> strings = new ArrayList<>();

        String letters = combination.get(digits.charAt(0));
        for (char letter : letters.toCharArray()) {
            strings.addAll(combine(letter, letterCombinations(digits.substring(1))));
        }
        return strings;
    }

    private List<String> getStrings(String digits) {
        List<String> list = new ArrayList<>();
        String s = combination.get(digits.charAt(0));
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            list.add(String.valueOf(aChar));
        }
        return list;
    }

    private List<String> combine(char letter, List<String> strings) {
        return strings.stream().map(s -> letter + s).collect(Collectors.toList());
    }
}