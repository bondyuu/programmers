import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> allow = new ArrayList<>();
        for(int i = 0; i <= skill.length(); i++){
            allow.add(skill.substring(0,i));
        }

        for (String sk : skill_trees) {
            for(char c: sk.toCharArray()){
                if (!skill.contains(String.valueOf(c))){
                    sk = sk.replace(String.valueOf(c),"");
                }
            }
            System.out.println(sk);
            if (allow.contains(sk)) {
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(sol.solution("CBD", skill_trees));
    }
}