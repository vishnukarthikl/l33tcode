import java.util.HashMap;
import java.util.Map;

public class FractionString {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "NaN";
        }
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        StringBuilder stringBuilder = new StringBuilder();
        if (n * d < 0) {
            stringBuilder.append("-");
        }
        n = Math.abs(n);
        d = Math.abs(d);
        long q = n / d;
        long r = n % d;
        stringBuilder.append(q);
        if (r == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        Map<Integer, Integer> repeatingLocation = new HashMap<>();
        while (r != 0) {
            if (repeatingLocation.containsKey((int) r)) {
                stringBuilder.insert(repeatingLocation.get((int) r), "(");
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else {
                repeatingLocation.put((int) r, stringBuilder.length());
                r = r * 10;
                long i = r / d;
                stringBuilder.append(i);
                r = r % d;
            }
        }
        return stringBuilder.toString();
    }
}