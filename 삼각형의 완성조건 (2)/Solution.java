import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);

        for (int i = sides[1] - sides[0] + 1; i < sides[0] + sides[1]; i++) {
            if (i <= sides[1] && sides[1] < i + sides[0]) {
                answer++;
            } else if (i > sides[1] && i < sides[0] + sides[1]) {
                answer++;
            }
        }
        return answer;
    }
}