import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String str = Integer.toString(n,k);
        String[] arr = str.split("0");
//        System.out.println(Arrays.toString(arr));
        return countPrimeNum(arr);
    }

    public int countPrimeNum(String[] arr) {
        int answer = 0;

        for(String str: arr){
            if(str.equals("")) {
                continue;
            }

            long k = Long.parseLong(str);

            if (isPrime(k)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long k) {
        if (k == 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(k); i++) {
            if(k % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Random rn = new Random();

        for(int i = 0; i <= 1000; i++) {
            int a = rn.nextInt(1000000);
            int b =  rn.nextInt(3,10);
            System.out.println("a : " + a);
            System.out.println("b : " + b);
            System.out.println(sol.solution(a, b));
        }

    }
}