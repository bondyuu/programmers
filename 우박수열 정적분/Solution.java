import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> list = new ArrayList<>();
        list.add(k);
        while (k != 1){
            if (k % 2 == 0){
                k /= 2;
                list.add(k);
            } else {
                k = k * 3 + 1;
                list.add(k);
            }
        }

        int i = 0;
        for(int[] point : ranges){
            int start = point[0];
            int end = list.size() - 1 + point[1];
            System.out.println("i : " + i + ", start : " + start + ", end : " + end);
            if(start > end) {
                answer[i] = -1;
                i++;
            } else if (start == end) {
                answer[i] = 0;
                i++;
            } else {
                for (int j = start; j < end; j++){
                    answer[i] += ( (double) list.get(j) + list.get(j+1)) / 2;
                }
                i++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
        System.out.println(Arrays.toString(solution(5, ranges)));
    }
}