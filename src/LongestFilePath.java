import java.util.HashSet;
import java.util.Set;

public class LongestFilePath {

    public int solution(String input) {
        Set<String> validExtensions = getValidExtensions();

        String[] split = input.split("\n");
        int totalLength = 0;
        int[] levelLength = new int[split.length + 1];
        levelLength[0] = 1;
        for (String line : split) {
            String name = line.trim();
            int level = calculateLevel(line);
            int length = name.length();
            levelLength[level] = levelLength[level - 1] + 1 + length;
            if (isValidExtension(validExtensions, name)) {
                totalLength = (totalLength + levelLength[level] - 1) % 1000000007;
            }
        }
        return totalLength;
    }

    private boolean isValidExtension(Set<String> validExtensions, String name) {
        return name.contains(".") && validExtensions.contains(name.substring(name.lastIndexOf(".")));
    }

    private Set<String> getValidExtensions() {
        return new HashSet<String>() {{
            add(".jpeg");
            add(".png");
            add(".gif");
        }};
    }

    private int calculateLevel(String line) {
        return line.lastIndexOf(" ") + 2;
    }

}
