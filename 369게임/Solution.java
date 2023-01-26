class Solution {
    public int solution(int order) {
        int answer = 0;
        String or = String.valueOf(order);

        for (int i = 0; i < or.length(); i++) {
            if (or.charAt(i) - '0' != 0 && (or.charAt(i) - '0') % 3 == 0) {
                answer++;
            }
        }
        return answer;
    }
}