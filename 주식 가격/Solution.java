import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++){
            int price = prices[i];

            if (dq.isEmpty()) {
                dq.push(i);
                continue;
            }

            while (!dq.isEmpty() && prices[dq.peek()] > prices[i]) {
                int idx = dq.peek();
                answer[idx] = i - idx;
                dq.poll();
            }
            dq.push(i);

        }
//        System.out.println(dq);

        while (!dq.isEmpty()) {
            int idx = dq.peek();
            answer[idx] = prices.length - idx -1;
            dq.poll();
        }
//        System.out.println(dq);
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(sol.solution(prices)));
    }
}