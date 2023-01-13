import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String bab: babbling) {
            if(bab.contains("ayaaya") || bab.contains("yeye") || bab.contains("woowoo") || bab.contains("mama")){
                continue;
            }

            bab = bab.replace("aya"," ");
            bab = bab.replace("ye"," ");
            bab = bab.replace("woo"," ");
            bab = bab.replace("ma"," ");
            bab = bab.replace(" ","");
            if (bab.equals("")) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(sol.solution(babbling));
    }
}