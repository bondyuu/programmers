class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (isComposite(i)) {
                answer++;
            }
        }


        return answer;
    }

    public boolean isComposite(int n) {
        int k = 0;
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return false;
        }

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                k++;
            }
        }

        return k > 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(10));
    }
}