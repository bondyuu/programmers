import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("T", 0);
        map.put("R", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++){
            String[] arr = survey[i].split("");
            if(choices[i]<4){
                map.replace(arr[0], map.get(arr[0]) + (4 - choices[i]));
            } else {
                map.replace(arr[1], map.get(arr[1]) + (choices[i] - 4));
            }
        }
        System.out.println(map.get("A"));
        System.out.println(map.get("N"));
        answer = calc(map);
        return answer;
    }

    public static String calc(Map<String, Integer> map){
        String ans = "";

        int RT = map.get("R") - map.get("T");
        int CF = map.get("C") - map.get("F");
        int JM = map.get("J") - map.get("M");
        int AN = map.get("A") - map.get("N");

        ans += RT >= 0? "R":"T";
        ans += CF >= 0? "C":"F";
        ans += JM >= 0? "J":"M";
        ans += AN >= 0? "A":"N";
        return ans;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey,choices));
    }
}