import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String k: s.split("")) {
            map.put(k, map.getOrDefault(k,0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(String key: map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        Collections.sort(list);
        for (String k: list) {
            answer += k;
        }
        return answer;
    }
}