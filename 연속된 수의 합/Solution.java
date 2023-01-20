import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center = total / num;
        int start;


        if (num % 2==1){
            start = center -num/2;
        } else {
            start = center - num/2 +1;
        }

        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start;
            start++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(3,12)));
        System.out.println(Arrays.toString(sol.solution(4,14)));
    }
}