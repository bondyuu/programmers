import java.util.Arrays;

class Solution {
    boolean[] used;
    int[][] map;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        used = new boolean[n];
        map = computers;

        for (int i = 0; i < n; i++) {
//            System.out.println("i : " + i + ", used : " + Arrays.toString(used));
            if (!used[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int i) {
        used[i] = true;

        for (int j = 0; j < map[i].length; j++) {
            if (used[j]==false && map[i][j] == 1) {
                dfs(j);
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(sol.solution(3, computers));
    }

}