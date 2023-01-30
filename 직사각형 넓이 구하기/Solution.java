import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return o1[0]- o2[0];
                } else if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return -1;
            }
        });

        int r = dots[1][1] - dots[0][1];
        int c = dots[2][0] - dots[1][0];
        return r * c;
    }
}