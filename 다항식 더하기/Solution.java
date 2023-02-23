import java.util.Arrays;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int coefficient = 0;
        int constant = 0;
        polynomial = polynomial.replaceAll(" ","");
        String[] array = polynomial.split("\\+");

        for (String k : array) {
            if (k.contains("x")) {
                if (k.equals("x")) {
                    coefficient++;
                } else {
                    coefficient += Integer.parseInt(k.substring(0,k.length()-1));
                }
            } else {
                constant += Integer.parseInt(k);
            }
        }
        if (coefficient != 0){
            if (coefficient == 1){
                answer += "x";
            } else {
                answer += String.valueOf(coefficient) + "x";
            }
        }

        if (coefficient==0 && constant != 0) {
            answer += String.valueOf(constant);
        }

        if (coefficient != 0 && constant != 0){
            answer += " + " + String.valueOf(constant);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String polynomial = "3x + 7 + x";
        System.out.println(sol.solution(polynomial));
    }
}