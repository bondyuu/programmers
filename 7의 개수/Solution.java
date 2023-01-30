class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int k : array) {
            for(char c: String.valueOf(k).toCharArray()) {
                if (c == '7') {
                    answer++;
                }
            }
        }

        return answer;
    }
}