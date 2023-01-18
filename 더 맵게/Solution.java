import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }

            int a = pq.poll();
            int b = pq.poll();
            int s = a + 2 * b;
            pq.offer(s);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12}; //3 5 9 10 12

        System.out.println(sol.solution(scoville, 7));
    }
}