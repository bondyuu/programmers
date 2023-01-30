import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        int[] arr = emergency.clone();
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[arr.length - 1 - i], i+1);
        }

        for(int i = 0; i  <emergency.length; i++) {
            answer[i] = map.get(emergency[i]);
        }
        return answer;
    }
}