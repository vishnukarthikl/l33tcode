import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return String.format("{%d,%d}", start, end);
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Interval current = intervals.get(0);
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (current.end < next.end && next.start <= current.end) {
                current = new Interval(current.start, next.end);
            } else if (current.end < next.start) {
                result.add(current);
                current = next;
            }
            if (i == intervals.size() - 1) {
                result.add(current);
            }
        }
        return result;
    }
}