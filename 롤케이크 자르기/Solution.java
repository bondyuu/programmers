import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> old = new HashMap<>();
        Map<Integer, Integer> young = new HashMap<>();

        for (int k : topping) {
            old.put(k, old.getOrDefault(k, 0) + 1);
        }
        System.out.println(old);
        for (int k : topping) {

            if (old.get(k) > 1) {
                old.put(k, old.get(k) - 1);
            } else {
                old.remove(k);
            }

            young.put(k, old.getOrDefault(old.get(k), 0) + 1);

            if (old.size() == young.size()) {
                answer++;
            }
        }



        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(sol.solution(topping));
    }
}