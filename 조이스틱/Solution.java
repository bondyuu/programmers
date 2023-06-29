class Solution {
    public int solution(String name) {
        int answer = 0;

        int min = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += getToMove(name.charAt(i));

            int k = i + 1;
            while (k < name.length() && name.charAt(k) == 'A') {
                k++;
            }
            min = Math.min(min, (i*2) + name.length() - k);
            min = Math.min(min, i + (name.length() - k)*2);
        }
        answer += min;
        return answer;
    }

    private int getToMove(char c) {
        int a = c - 'A';
        int b = 'Z' - c + 1;

        return Math.min(a, b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("JEROEN"));
    }
}