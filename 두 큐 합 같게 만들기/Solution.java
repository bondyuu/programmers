import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;

        Deque<Long> dq1 = new ArrayDeque<>();
        Deque<Long> dq2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            dq1.offer((long)queue1[i]);
            sum1 += queue1[i];

            dq2.offer((long)queue2[i]);
            sum2 += queue2[i];
        }

        if ((sum1+sum2)%2==1){

            return -1;
        }
        while (answer < 3*queue1.length-2) {
            if (sum1 > sum2) {
                long k = dq1.poll();
                dq2.offer(k);
                sum1 -= k;
                sum2 += k;
            } else if (sum1 < sum2){
                long k = dq2.poll();
                dq1.offer(k);
                sum2 -= k;
                sum1 += k;
            } else {
                break;
            }
            answer++;
        }

        if (answer == 3*queue1.length-2){
            return -1;
        }

        return answer;
    }
}