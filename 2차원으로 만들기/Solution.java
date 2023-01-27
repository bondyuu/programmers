class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];

        for (int i = 0; i < num_list.length; i++) {
            int m = i / n;
            int r = i % n;

            answer[m][r] = num_list[i];
        }
        return answer;
    }
}