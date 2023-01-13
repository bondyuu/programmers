class Solution {
    public int solution(int a, int b, int n) { //3 1 40
        int answer = 0;


        while (n>(a-1)) {                         //40 27 18 12 8 6 4 3   2
            System.out.println(answer);
            answer += (n / a) * b;           //26  18 12 8  4 4 2 2   0
            n = (n / a) * b + n%a;                         //1   0  0  0  2 0 1 0   2
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(3,2,40));
    }
}