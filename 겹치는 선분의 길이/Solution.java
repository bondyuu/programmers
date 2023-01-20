import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr: lines) {
            for (int i = arr[0]; i < arr[1]; i++) {
                map.put(i, map.getOrDefault(i,0)+1);
            }
        }

        for (int key: map.keySet()) {
            if (map.get(key)>=2) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] lines = {{0, 5}, {3, 9}, {1, 10}};
        System.out.println(sol.solution(lines));
    }
}