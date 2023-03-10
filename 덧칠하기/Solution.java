import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int k : section) {
            dq.offer(k);
        }

        int idx = section[0];
        while (!dq.isEmpty()) {
            if (dq.peek() - idx + 1 <= m) {
                dq.poll();
            } else {
                idx = dq.poll();
                answer++;
                if (n - idx + 1 <= m) {
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] section = {2,3,6};
        System.out.println(sol.solution(8,4, section));
    }
}