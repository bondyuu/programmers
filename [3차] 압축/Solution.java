import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), c - 'A' + 1);
        }

        int i = 0;

        outer:
        while (i < msg.length()) {

            if (i == msg.length() -1) {
                answer.add(map.get(String.valueOf(msg.charAt(i))));
                break;
            }

            for(int j = i + 1; j <= msg.length(); j++) {
                String now = msg.substring(i,j);
                String next = "";
                if (j+1 <=msg.length()){
                    next = msg.substring(i,j+1);
                }

                if(!next.equals("") && map.containsKey(now) && !map.containsKey(next)) {
                    answer.add(map.get(now));
                    map.put(next, map.size()+1);
                    i += j - i;
                    continue outer;
                } else if (next.equals("") && map.containsKey(now)) {
                    answer.add(map.get(now));
                    i += j-i;
                }


            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("KAKAO"));
    }
}