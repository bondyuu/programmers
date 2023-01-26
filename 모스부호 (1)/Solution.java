import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < morse.length; i++) {
            map.put(morse[i], String.valueOf((char)(i + 'a')));
        }

        String[] arr = letter.split(" ");

        for (String str : arr) {
            answer += map.get(str);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(".... . .-.. .-.. ---"));
    }
}