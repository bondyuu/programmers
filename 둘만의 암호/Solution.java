import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int ALPHABET_NUM = 26;
        List<Character> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++){
            list.add(c);
        }
        for (char c : skip.toCharArray()) {
            list.remove(list.indexOf(c));
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            int idx= list.indexOf(c) + index;
            answer += list.get(idx % (ALPHABET_NUM - skip.length()));
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aukks","wbqd",5));
    }
}