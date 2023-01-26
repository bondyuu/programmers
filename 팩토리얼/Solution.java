class Solution {
    public int solution(int n) {
        int answer = 1;

        while (fac(answer) <= n) {
            answer++;
        }
        return answer -1;
    }

    public int fac(int n) {
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }
}