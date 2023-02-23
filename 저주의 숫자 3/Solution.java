class Solution {
    public int solution(int n) {
        int answer = n;
        int idx = 1;
        while (idx <= answer) {

            if (idx % 3 == 0 || String.valueOf(idx).contains("3")) {
                answer++;
            }

            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3));
    }
}