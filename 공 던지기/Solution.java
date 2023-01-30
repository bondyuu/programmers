class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;

        int idx = 2 * (k - 1);

        answer = numbers[idx % numbers.length];

        return answer;
    }
}