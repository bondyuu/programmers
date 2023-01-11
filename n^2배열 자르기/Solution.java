import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        int a = (int) (left/n);
        int b = (int) (right/n);

        for(int i = a; i <= b; i++) {
            int k = 0;
            int p = n;

            if(i == a) {
                k = (int) (left%n);
            }
            if(i == b) {
                p = (int) (right%n);
                p++;
            }
            for(int j = k; j < p; j++) {
//                System.out.println("i : "+ i);
//                System.out.println("j : " +j);
                if (j < i+1){
                    answer.add(i+1);
                } else {
                    answer.add(j+1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4,7,14));
    }
}