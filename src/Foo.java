import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Foo {

    public static class Node {
        private Integer index;
        private List<Integer> knownZombies;

        public Node(Integer index, List<Integer> knownZombies) {
            this.index = index;
            this.knownZombies = knownZombies;
        }

        public int getIndex() {
            return index;
        }

        public List<Integer> getKnownZombies() {
            return knownZombies;
        }
    }

    static int zombieCluster(String[] zombies) {
        HashMap<Integer, Node> relationMap = createRelationMap(zombies);
        HashSet<Integer> visited = new HashSet<>();
        int clusters = 0;
        for (Integer zombie : relationMap.keySet()) {
            int before = visited.size();
            dfs(zombie, relationMap, visited);
            int after = visited.size();
            if (after - before > 0) {
                clusters++;
            }
        }
        return clusters;
    }

    private static void dfs(Integer start, HashMap<Integer, Node> relationMap, HashSet<Integer> visited) {
        if (visited.contains(start)) {
            return;
        }

        Node zombie = relationMap.get(start);
        visited.add(start);
        for (Integer knownZombie : zombie.getKnownZombies()) {
            dfs(knownZombie, relationMap, visited);
        }
    }

    private static HashMap<Integer, Node> createRelationMap(String[] zombies) {
        HashMap<Integer, Node> zombieRelationMap = new HashMap<>();
        for (int zombie = 0; zombie < zombies.length; zombie++) {
            char[] relations = zombies[zombie].toCharArray();
            ArrayList<Integer> knownZombie = new ArrayList<>();
            for (int i = 0; i < relations.length; i++) {
                char relation = relations[i];
                if (relation == '1') {
                    knownZombie.add(i);
                }
            }
            zombieRelationMap.put(zombie, new Node(zombie, knownZombie));
        }
        return zombieRelationMap;
    }

}
