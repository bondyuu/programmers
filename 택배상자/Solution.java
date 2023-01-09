import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> sub = new Stack<>();

        int defOr = 1;
        int orderIdx = 0;

        while(true) {
            if(!sub.isEmpty() && order[orderIdx] == sub.peek()){
                answer++;
                orderIdx++;
                sub.pop();

                continue;
            }

            if (defOr > order.length){
                break;
            }

            if(order[orderIdx] == defOr){
                answer++;
                orderIdx++;
                defOr++;

                continue;
            }

            sub.push(defOr);
            defOr++;
        }

        return answer;
    }
}