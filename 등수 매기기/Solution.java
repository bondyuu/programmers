import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] score = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
        System.out.println(Arrays.toString(sol.solution(score)));
    }
}