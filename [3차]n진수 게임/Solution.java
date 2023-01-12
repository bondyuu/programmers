class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int needLen = m*(t-1) + p;

        int idx = 0;
        while (str.length() < needLen) {
            str += Integer.toString(idx, n);
            idx++;
        }

        str = str.toUpperCase();

        for(int i = p-1; i <= needLen; i += m) {
            answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,4,2,1));
    }
}