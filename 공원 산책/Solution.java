import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<String> direction = Arrays.stream(new String[]{"S", "N", "W", "E"}).collect(Collectors.toList());
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int[] start = new int[2];
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                start[0] = i;
                start[1] = park[i].indexOf("S");
                break;
            }
        }

        for (String route: routes) {
            String dir = route.split(" ")[0];
            int dist = Integer.parseInt(route.split(" ")[1]);

            if (canMove(start, dir, dist, park)) {
                start[0] += dx[direction.indexOf(dir)] * dist;
                start[1] += dy[direction.indexOf(dir)] * dist;
            }
        }

        return start;
    }

    public boolean canMove(int[] start, String dir, int dist, String[] park) {
        int row = park.length;
        int col = park[0].length();
        int[] move = {dx[direction.indexOf(dir)] * dist, dy[direction.indexOf(dir)] * dist};

        if (start[0] + move[0] >= row || start[0] + move[0] < 0 || start[1] + move[1] >= col || start[1] + move[1] < 0) {
            return false;
        }

        for (int i = 1; i <= dist; i++) {
            if (park[start[0] + dx[direction.indexOf(dir)] * i].charAt(start[1] + dy[direction.indexOf(dir)] * i)==('X')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        System.out.println(Arrays.toString(sol.solution(park, routes)));
    }
}