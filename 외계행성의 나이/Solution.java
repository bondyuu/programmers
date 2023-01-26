import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int age) {
        String answer = "";
        List<String> list = new ArrayList<>();

        for (char c = 'a'; c <= 'j'; c++) {
            list.add(String.valueOf(c));
        }

        String[] arr = String.valueOf(age).split("");
        for (int i = 0; i < arr.length; i++) {
            answer += list.get(Integer.parseInt(arr[i]));
        }

        return answer;
    }
}