import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> splits = new HashMap<>();
        return recurse(s, wordDict, splits);
    }

    private List<String> recurse(String s, Set<String> wordDict, HashMap<String, List<String>> splits) {
        if (splits.containsKey(s)) {
            return splits.get(s);
        }
        List<String> combinedWords = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String rest = s.replaceFirst(word, "");
                if (rest.isEmpty()) {
                    combinedWords.add(word);
                } else {
                    List<String> restWords = recurse(rest, wordDict, splits);
                    if (!restWords.isEmpty()) {
                        combinedWords.addAll(combine(word, restWords));
                    }
                }
            }
        }
        splits.put(s, combinedWords);
        return combinedWords;
    }

    private List<String> combine(String word, List<String> restWords) {
        return restWords.stream().map(restWord -> word + " " + restWord).collect(Collectors.toList());
    }

}