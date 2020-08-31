/**
 * 2020/8/31 19:24
 *
 * @author iJuly
 * @version 1.0
 */

import java.util.*;

public class KeysAndRooms {
    int num = 0;

    public boolean canVisitAllRoomsDfsI(List<List<Integer>> rooms) {
        // dfs-iteration
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        return num == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int p, boolean[] visited) {
        visited[p] = true;
        ++num;
        for (int i : rooms.get(p)) {
            if (!visited[i]) {
                dfs(rooms, i, visited);
            }
        }
    }

    public boolean canVisitAllRoomsDfsII(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (int j : rooms.get(i))
                if (!visited.contains(j)) {
                    stack.add(j);
                    visited.add(j);
                    if (rooms.size() == visited.size()) return true;
                }
        }
        return rooms.size() == visited.size();
    }

    public boolean canVisitAllRoomsBfs(List<List<Integer>> rooms) {
        // bfs
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        queue.offer(0);
        visited[0] = true;
        int num = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ++num;
            for (int j : rooms.get(i)) {
                if (!visited[j]){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
        return num == rooms.size();
    }
}
