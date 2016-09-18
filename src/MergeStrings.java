public class MergeStrings {

    static String mergeStrings(String a, String b) {
        int max = Math.max(a.length(), b.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < max; i++) {
            if (i < a.length()) {
                stringBuilder.append(a.charAt(i));
            }
            if (i < b.length()) {
                stringBuilder.append(b.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
