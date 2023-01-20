class Solution {
    public int solution(int[] common) {
        int answer = 0;

        if (common[0] + (common.length -1)*(common[1]-common[0]) == common[common.length-1]) {
            answer = common[common.length-1] + common[1] - common[0];
        } else {
            answer = common[common.length - 1] * (common[1] / common[0]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] common = {1,2,3,4};
        System.out.println(sol.solution(common));
    }
}