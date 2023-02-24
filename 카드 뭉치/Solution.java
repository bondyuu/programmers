import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> gQueue = new LinkedList<>(Arrays.asList(goal));

        while(!gQueue.isEmpty()) {
            if(!queue1.isEmpty() && queue1.peek().equals(gQueue.peek())) {
                queue1.poll();
                gQueue.poll();
                continue;
            }
            if(!queue2.isEmpty() && queue2.peek().equals(gQueue.peek())) {
                queue2.poll();
                gQueue.poll();
                continue;
            }

            return "No";
        }
        return "Yes";
    }
}