import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Info start;
    Info lever;
    Info end;
    public int solution(String[] maps) {

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new Info(i, j, 0);
                }
                if (maps[i].charAt(j) == 'L') {
                    lever = new Info(i, j, 0);
                }
                if (maps[i].charAt(j) == 'E') {
                    end = new Info(i, j, 0);
                }
            }
        }

        int toLever = bfs(start, lever, maps);
        int toEnd = bfs(lever, end, maps);

        if (toLever == -1 || toEnd == -1) {
            return -1;
        }

        return toLever + toEnd;
    }

    public int bfs(Info from, Info to, String[] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        Queue<Info> queue = new LinkedList<>();
        queue.offer(from);
        visited[from.x][from.y] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if (now.x == to.x && now.y == to.y) {
                return now.chk;
            }

            for (int j = 0; j < dx.length; j++) {
                int x = now.x + dx[j];
                int y = now.y + dy[j];
                if (y < 0 || y >= maps[0].length() || x < 0 || x >= maps.length) {
                    continue;
                }
                if (!visited[x][y] && maps[x].charAt(y) != 'X') {
                    queue.offer(new Info(x,y, now.chk + 1));
                    visited[x][y] =true;
                }
            }

        }

        return -1;
    }

    class Info {
        int x;
        int y;
        int chk;
        public Info(int x, int y, int chk) {
            this.x = x;
            this.y = y;
            this.chk = chk;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(sol.solution(maps));
    }
}