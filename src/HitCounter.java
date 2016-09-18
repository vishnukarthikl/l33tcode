import java.util.HashMap;

public class HitCounter {

    public static final int THRESHOLD = 300;
    private final HashMap<Integer, Integer> hitMap;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hitMap = new HashMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hitMap.putIfAbsent(timestamp, 0);
        Integer oldCount = hitMap.get(timestamp);
        hitMap.put(timestamp, oldCount + 1);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = timestamp; i > timestamp - THRESHOLD && i > 0; i--) {
            count += hitMap.getOrDefault(i, 0);
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */