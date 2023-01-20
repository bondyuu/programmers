import java.util.Arrays;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        answer[1] = denom1 * denom2 ;
        answer[0] = numer1 * denom2 + numer2 * denom1;

        int gcd = getGCD(answer[0], answer[1]);

        answer[0] /= gcd;
        answer[1] /= gcd;

        return answer;
    }

    public int getGCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        for (int i = min; i>1; i--){

            if (min % i == 0 && max % i ==0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(9,2,1,3)));
    }
}