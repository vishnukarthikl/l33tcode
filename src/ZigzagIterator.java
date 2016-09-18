import java.util.List;

public class ZigzagIterator {

    private final List<Integer> v1;
    private final List<Integer> v2;
    private int current;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.current = 0;
    }

    public int next() {
        int i = current / 2;
        int value;
        if (i < v1.size() && i < v2.size()) {
            if ((current % 2) == 0) {
                value = v1.get(i);
            } else {
                value = v2.get(i);
            }
        } else if (i >= v1.size()) {
            value = v2.get(current - v1.size());
        } else {
            value = v1.get(current - v2.size());
        }
        current++;
        return value;
    }

    public boolean hasNext() {
        return current < (v1.size() + v2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */