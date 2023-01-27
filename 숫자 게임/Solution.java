import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        boolean[] used = new boolean[B.length];

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int a : A) {

            while (i < B.length) {
                if (!used[i] && B[i] > a) {
                    used[i] = true;
                    answer++;
                    i++;
                    break;
                }
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(sol.solution(A, B));
    }
}