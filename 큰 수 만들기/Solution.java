class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");

        int len = number.length() - k;

        int start = 0;
        while (answer.length() < len) {
            int end = k + answer.length();
            char max = '0';
            for (int i = start; i <= end; i++) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    start = i + 1;
                }
            }
            answer.append(String.valueOf(max));
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("4177252841",4));//10
    }
}