import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int min = 0;
            for (char c : targets[i].toCharArray()) {
//                System.out.println("c : " + c + ", cnt : " + findMinInKeymap(c, keymap));
                min += findMinInKeymap(c, keymap);
            }
            if (min == 0) {
                answer[i] = -1;
            } else {
                answer[i] = min;
            }
        }

        return answer;
    }

    public int findMinInKeymap(char c, String[] keymap) {
        int answer = 101;
        for(String key : keymap) {
            int idx = key.indexOf(c);
            if (idx == -1){
                continue;
            }
            if (idx < answer) {
                answer = idx + 1;
            }
        }

        if (answer == 101) {
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        System.out.println(Arrays.toString(sol.solution(keymap, targets)));
    }
}