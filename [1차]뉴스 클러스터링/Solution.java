import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.equals(str2)) {
            return 65536;
        }

        Map<String, int[]> map = new HashMap<>();

        toSub(map, str1, 0);
        toSub(map, str2, 1);

        answer = J(map);
        return answer;
    }

    public void toSub(Map<String, int[]> map, String str, int idx) {
        for (int i = 0; i < str.length() - 1; i++) {

            if (isLetter(str.charAt(i))&& isLetter(str.charAt(i+1))) {

                String temp = str.substring(i,i+2);

                if(map.containsKey(temp)) {
                    int[] arr = map.get(temp);
                    arr[idx]++;
                    map.replace(temp, arr);
                } else{
                    int[] arr = new int[2];
                    arr[idx] = 1;
                    map.put(temp,arr);
                }

            }
        }
    }

    public boolean isLetter(char c) {
        return c - 'a' >= 0 && c - 'a' <= 25;
    }

    public int J(Map<String, int[]> map){
        int answer = 0;

        if (map.isEmpty()){
            answer = 1;
        } else {
            List<int[]> values = map.values().stream().collect(Collectors.toList());
            int minus = 0;
            int plus = 0;

            for(int[] value: values) {
                minus += Math.min(value[0], value[1]);
                plus += Math.max(value[0], value[1]);
            }

            answer = (int)(minus/(double)plus * 65536);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("FRANCE", "french"));
        System.out.println(sol.solution("handshake", "shake hands"));
        System.out.println(sol.solution("aa1+aa2", "AAAA12"));
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));
    }
}