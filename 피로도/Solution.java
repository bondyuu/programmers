import java.util.Arrays;
import java.util.Comparator;

class Solution {
    int answer = 0;
    int[] clear;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        clear = new int[dungeons.length];

        dfs(k,0);

        return answer;
    }

    public void dfs(int fatigue, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            if (clear[i]!=1 && dungeons[i][0] <= fatigue) {
                clear[i] = 1;
                dfs(fatigue-dungeons[i][1], cnt+1);
                clear[i] = 0;
            }

            answer = Math.max(answer, cnt);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(sol.solution(80,dungeons));
    }
}