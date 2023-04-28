import java.util.Arrays;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {

                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], j+1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] wallpaper = {"..", "#."};
        System.out.println(Arrays.toString(sol.solution(wallpaper)));
    }
}