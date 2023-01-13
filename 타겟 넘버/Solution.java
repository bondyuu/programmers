class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int idx, int target, int sum) {
        if(idx == numbers.length) {
            if (target == sum) {
                answer++;
                }
        } else {
            dfs(numbers, idx + 1, target, sum + numbers[idx]);
            dfs(numbers, idx +1, target, sum - numbers[idx]);
        }
    }
}
