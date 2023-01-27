import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] route1, int[] route2) {
                return route1[1] - route2[1];
            }
        });

        int now = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(now < route[0]) {
                now = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(sol.solution(routes));
    }
}