import java.util.Arrays;

class Solution {

    int del = 0;
    int pick = 0;
    long answer = 0;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;

                while (del < deliveries[i] || pick < pickups[i]) {
                    cnt++;
                    del += cap;
                    pick += cap;
                }

                del -= deliveries[i];
                pick -= pickups[i];
                answer += (long) (i+1)*cnt*2;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(sol.solution(4,5,deliveries,pickups));
    }
}