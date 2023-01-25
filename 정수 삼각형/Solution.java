import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] triangle) {

        for (int i = 1; i < triangle.length; i++) {
            int[] row = triangle[i];

            for(int j = 0; j < row.length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                    continue;
                }

                if (j == row.length -1) {
                    triangle[i][j] += triangle[i-1][j-1];
                    continue;
                }

                triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
            }
        }
        Arrays.sort(triangle[triangle.length-1]);

        return triangle[triangle.length-1][triangle[triangle.length-1].length -1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(sol.solution(triangle));
    }
}