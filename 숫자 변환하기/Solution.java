import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        dq.offer(x);
        set.add(x);
        int answer = 0;

        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int k = dq.pop();
                if (k == y) {
                    return answer;
                }

                addNextElements(dq, k, y, n, set);
            }
            answer++;
        }

        return -1;
    }

    public void addNextElements(Deque<Integer> dq, int x, int y, int n, Set<Integer> set) {
        if (x + n <= y && !set.contains(x+n)) {
            dq.offer(x + n);
            set.add(x + n);
        }
        if (x * 2 <= y && !set.contains(x*2)) {
            dq.offer(x * 2);
            set.add(x * 2);
        }
        if (x * 3 <= y && !set.contains(x*3)) {
            dq.offer(x * 3);
            set.add(x * 3);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10, 40, 5));
    }
}