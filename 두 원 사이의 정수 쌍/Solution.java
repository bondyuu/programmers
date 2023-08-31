class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 0; i < r2; i++) {
            long y2 = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));

            long y1;
            if (i <= r1) {
                y1 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            } else {
                y1 = 0;
            }

            answer += y2 - y1 + 1;
        }

        return 4 * (answer + r1 - r2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,3));
    }
}