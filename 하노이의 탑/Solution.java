import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {//3 7 15 31
    public int[][] solution(int n) {
        List<int[]> list = hanoi(n,1,3);
        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }



    public List<int[]> hanoi(int n, int from, int to) {
        List<int[]> ans = new ArrayList<>();
        int third = 6 -from -to;
        if (n == 1){
            ans.add(new int[] {from, to});
            return ans;
        }
        ans.addAll(hanoi(n-1,from,third));
        ans.addAll(hanoi(1,from,to));
        ans.addAll(hanoi(n-1,third,to));
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int[] k: sol.solution(15)) {
            System.out.println(Arrays.toString(k));
        }

    }
}