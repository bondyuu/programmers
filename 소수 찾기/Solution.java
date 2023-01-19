import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    int[] visit;
    String number;

    public int solution(String numbers) {

        this.number = numbers;
        visit = new int[numbers.length()];

        dfs("", 0);

        return set.size();
    }

    public void dfs(String str, int len) {
        if (len != 0) {
            int k = Integer.parseInt(str);
            if(isPrime(k)) {
                set.add(k);
            }

        }
        if (len < number.length()){
            for (int i = 0; i < number.length(); i++) {
                if (visit[i]==0) {
                    String t =str + number.charAt(i);
                    visit[i] = 1;
                    dfs(t, len + 1);
                    visit[i] = 0;
                }
            }
        }

    }

    public boolean isPrime(int k) {
        if (k == 0 || k == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("17"));
    }
}