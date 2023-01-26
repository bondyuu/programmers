import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        Map<String, Integer> bMap = new HashMap<>();
        Map<String, Integer> aMap = new HashMap<>();

        for (int i = 0; i < before.length(); i++) {
            bMap.put(before.substring(i,i+1), bMap.getOrDefault(before.substring(i,i+1), 0)+1);
            aMap.put(after.substring(i,i+1), aMap.getOrDefault(after.substring(i,i+1), 0)+1);
        }


        return bMap.equals(aMap)?1:0;
    }
}