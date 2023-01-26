import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }

        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = s/n;
        }

        for(int i=0; i<s%n; i++){
            answer[i] ++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(2,9)));
    }
}