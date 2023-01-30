class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int p = i; p <= j; p++) {
            String str = String.valueOf(p);
            for(String a : str.split("")) {
                if (a.equals(String.valueOf(k))) {
                    answer++;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(1,13,1));
    }
}