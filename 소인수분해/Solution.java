import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();

        int i = 2;

        while (!isPrime(n)) {
            if (n%i == 0) {
                set.add(i);
                n /= i;
            } else {
                i++;
                while(!isPrime(i)) {
                    i++;
                }
            }
        }

        set.add(n);


        int[] answer = new int[set.size()];

        int p = 0;
        for (int a: set) {
            answer[p++] = a;
        }
        Arrays.sort(answer);
        return answer;
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.solution(420)));
    }
}