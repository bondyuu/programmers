import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] need = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            double k = (double) (100 - progresses[i]) / speeds[i];
            need[i] = (int)Math.ceil(k);
        }

        List<Integer> ans = new ArrayList<>();
        int d = need[0];
        int k = 0;

        for(int i = 0; i< need.length; i++) { //7 3 9
            if(need[i]<=d && i != need.length - 1) {
                k++;
                continue;
            }

            if(need[i]<=d && i == need.length - 1){
                ans.add(k + 1);

            } else {
                ans.add(k);
                k = 1;
                d = need[i];
                if(i == need.length -1) {
                    ans.add(k);
                }
            }

        }

        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}