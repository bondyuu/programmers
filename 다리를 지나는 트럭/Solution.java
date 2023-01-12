import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<String> dq = new ArrayDeque<>();
        int curWeight = 0;
        int time =1;
        int i = 0;
        while (true) {

            if (!dq.isEmpty() && time - Integer.parseInt(dq.peek().split(":")[0]) == bridge_length) {
                curWeight -= Integer.parseInt(dq.peek().split(":")[1]);
                dq.poll();
            }

            if (i< truck_weights.length&& dq.size() < bridge_length && curWeight + truck_weights[i] <= weight) {
                curWeight += truck_weights[i];
                dq.offer(time + ":" + truck_weights[i]);
                i++;
            }
            if(dq.isEmpty()){
                break;
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(sol.solution(100,100,truck_weights));
    }
}