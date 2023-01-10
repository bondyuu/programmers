import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String cate = clothes[i][1];
            if(map.containsKey(cate)){
                map.replace(cate, map.get(cate) + 1);
            } else {
                map.put(cate, 1);
            }
        }

        for(String key: map.keySet()){
            answer = answer * (map.get(key) + 1);
        }
        answer--;
        return answer;
    }
}