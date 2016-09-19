import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    static class Interval {
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
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1.start, o2.start));
        PriorityQueue<Interval> rooms = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));

        rooms.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval meeting = intervals[i];
            Interval earlierMeeting = rooms.poll();
            if (earlierMeeting.end <= meeting.start) {
                earlierMeeting.end = meeting.end;
            } else {
                rooms.add(meeting);
            }
            rooms.add(earlierMeeting);
        }
        return rooms.size();
    }
}