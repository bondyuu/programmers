import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = Arrays.stream(works).sum();

        if (n >= sum) {
            return answer;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int k : works) {
            pq.offer(k);
        }

        for (int i = 0; i < n; i++) {
            pq.offer(pq.poll() - 1);
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}