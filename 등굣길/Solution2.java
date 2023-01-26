import java.util.Arrays;

class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] map = new int[n+1][m+1];

        boolean[][] pud = new boolean[n+1][m+1];

        for(int[] puddle : puddles) {
            pud[puddle[1]][puddle[0]] = true;
        }
        for (boolean[] a : pud) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-----------------------");

        map[1][1] = 1;

        for (int[] a : map) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-----------------------");

        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i ==1 && j == 1) {
                    continue;
                }
                if (pud[i][j]){
                    map[i][j] = 0;
                } else {
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                }
            }
        }

        return map[n][m];
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int[][] puddles = {{2, 2}};
        System.out.println(sol.solution(4,3,puddles));
    }
}