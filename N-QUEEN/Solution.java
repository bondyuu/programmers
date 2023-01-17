import java.util.Arrays;

class Solution {
    int answer = 0;
    public int solution(int n) {

        if (n ==1) {
            return 1;
        } else if (n == 2){
            return 0;
        }

        for (int i = 0; i < n; i++) {
            int[][] map = new int[n][n];
            int[] start = new int[] {0,i};
            dfs(start,map);
        }

        return answer;
    }

    public void dfs(int[] start, int[][] map) {
        int r = start[0];
        int c = start[1];

        if (r == map.length-1) {
            for(int i = 0; i< map.length; i++) {
                if(map[r][i] == 0) {
                    answer++;
                }
            }
        } else {

            int[][] k = new int[map.length][map.length];
            for(int i = 0; i < k.length; i++) {
                for(int j= 0; j < k.length; j++) {
                    k[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < k.length; i++) {
                k[i][c] = 1;


                if(c+i<k.length && r+i <k.length) {
                    k[r+i][c+i] =1;

                }

                if (c-i>=0 && r+i < k.length){
                    k[r+i][c-i] =1;

                }

            }

            for (int i = 0; i < k.length; i++){

                if(k[r+1][i] == 0){
                    dfs(new int[]{r+1,i},k);
                }
            }
        }


    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(8));
    }
}