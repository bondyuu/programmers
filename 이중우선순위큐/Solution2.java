import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution2 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        int cnt = 0;
        for (String str: operations) {
            String action = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);

            if (action.equals("I")) {
                pq1.offer(num);
                pq2.offer(num);
                cnt++;
            }

            if (action.equals("D") && num == 1 && cnt != 0) {
                pq1.remove(pq2.peek());
                pq2.remove();
                cnt--;
            }

            if (action.equals("D") && num == -1 && cnt != 0) {
                pq2.remove(pq1.peek());
                pq1.remove();
                cnt--;
            }

        }

        System.out.println(pq1);
        System.out.println(pq2);

        if (cnt == 0) {
            return answer;
        } else if (cnt == 1) {
            if (operations[operations.length-1].endsWith("-1")) {
                answer[0] = pq1.peek();
                answer[1] = pq1.peek();
            } else { // (operations[operations.length-1].endsWith("1"))
                answer[0] = pq2.peek();
                answer[1] = pq2.peek();
            }

        } else {
            assert !pq1.isEmpty();
            assert !pq2.isEmpty();
            answer[0] = pq2.peek();
            answer[1] = pq1.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        System.out.println(Arrays.toString(sol.solution(operations)));
    }

}