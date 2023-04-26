import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Deque<Info> dq = new ArrayDeque<>();

        dq.offer(new Info(0, numbers[0]));

        for (int i = 1; i < numbers.length; i++) {

            while (!dq.isEmpty() && dq.getLast().value < numbers[i]) {
                Info last = dq.pollLast();
                answer[last.idx] = numbers[i];
            }

            dq.offer(new Info(i, numbers[i]));
        }

        while (!dq.isEmpty()) {
            Info info = dq.pollLast();
            answer[info.idx] = -1;
        }
        return answer;
    }

    class Info {
        private int idx;
        private int value;

        public Info(int idx, int value) {
            this.idx =idx;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(sol.solution(numbers)));
    }
}