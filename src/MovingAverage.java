public class MovingAverage {

    private final int[] window;
    private int sum;
    private int insert;
    private int elements;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        window = new int[size];
        this.sum = 0;
        this.elements = 0;
        this.insert = 0;
    }

    public double next(int val) {
        if (elements < window.length) elements++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        return sum * 1.0 / elements;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */