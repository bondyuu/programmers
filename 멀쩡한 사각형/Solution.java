import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long answer = (long) w *h;

        long GCD = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();


        return answer - ((((long) w / GCD) + ((long) h / GCD) - 1) * GCD);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(8,12));
    }
}