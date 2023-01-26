class Solution {
    int[][] map;
    int answer = 0;
    public int solution(int m, int n, int[][] puddles) {
        map = new int[m][n];

        for (int[] puddle: puddles) {
            map[puddle[0]-1][puddle[1]-1] = 1;
        }

        dfs(0,0);

        return answer;
    }

    public void dfs(int r, int c) {
        if (r == map.length-1 && c == map[0].length-1) {
            answer++;
        }

        if (r < map.length-1 && map[r+1][c] == 0) {
            dfs(r+1,c);
        }

        if (c < map[0].length - 1 && map[r][c+1] == 0) {
            dfs(r,c+1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] puddles = {{2, 2}};
        System.out.println(sol.solution(4,3,puddles));
    }
}