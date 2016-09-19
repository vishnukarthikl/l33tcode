public class Main {

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        MeetingRooms.Interval interval1 = new MeetingRooms.Interval(9, 16);
        MeetingRooms.Interval interval2 = new MeetingRooms.Interval(6, 16);
        MeetingRooms.Interval interval3 = new MeetingRooms.Interval(1, 9);
        MeetingRooms.Interval interval4 = new MeetingRooms.Interval(3, 15);
        int i = solution.minMeetingRooms(new MeetingRooms.Interval[]{interval1, interval2, interval3, interval4});
        System.out.println(i);
    }
}
