import java.util.Arrays;

class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")) {
            System.out.println("s : " + s);
            answer[0]++;
            int k = s.length();
            if(s.contains("0")){
                s = s.replace("0","");
            }
            answer[1] += k - s.length();
            System.out.println("answer : " + Arrays.toString(answer));
            s = Integer.toBinaryString(s.length());

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("110010101001"	));
    }
}