import java.util.LinkedList;
import java.util.Queue;

public class WallsGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> points = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    points.add(new int[]{i, j});
                }
            }
        }
        while (!points.isEmpty()) {
            int[] location = points.poll();
            int i = location[0];
            int j = location[1];
            int currentDistance = rooms[i][j];
            if (i - 1 >= 0)
                addDistance(i - 1, j, points, currentDistance, rooms);
            if (i + 1 < rooms.length)
                addDistance(i + 1, j, points, currentDistance, rooms);
            if (j - 1 >= 0)
                addDistance(i, j - 1, points, currentDistance, rooms);
            if (j + 1 < rooms[0].length)
                addDistance(i, j + 1, points, currentDistance, rooms);
        }
    }

    private void addDistance(int i, int j, Queue<int[]> points, int currentDistance, int[][] rooms) {
        if (rooms[i][j] == Integer.MAX_VALUE) {
            rooms[i][j] = currentDistance + 1;
            points.add(new int[]{i, j});
        }
    }

}