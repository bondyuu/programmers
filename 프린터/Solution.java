import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p: priorities) {
            pq.offer(p);
        }

        while (!pq.isEmpty()) {
            for(int i = 0; i<priorities.length; i++){
                if (pq.peek() == priorities[i]) {
                    answer++;
                    pq.poll();
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] priorities = {2, 1, 3, 2};
        System.out.println(sol.solution(priorities,2));
    }
}