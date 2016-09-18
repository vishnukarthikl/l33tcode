public class Strobogrammatic {
    public boolean isStrobogrammatic(String num) {
        int[] rotated = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int length = num.toCharArray().length;
        for (int i = 0; i <= length / 2; i++) {
            int number = num.charAt(i) - '0';
            int otherNumber = num.charAt(length - i - 1) - '0';
            if (rotated[number] != otherNumber) {
                return false;
            }
        }
        return true;
    }
}