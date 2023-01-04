import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            int[] subArr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(subArr);
            answer[i] = subArr[commands[i][2]-1];
        }

        return answer;
    }
}