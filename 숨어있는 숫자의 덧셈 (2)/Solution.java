class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String str = "0";
        for (int i = 0; i < my_string.length(); i++) {
            if (isNum(my_string.charAt(i))) {
                str += my_string.charAt(i);

                if (i < my_string.length()-1 && !isNum(my_string.charAt(i+1))) {
                    answer += Integer.parseInt(str);
                    str = "0";
                } else if (i == my_string.length()-1) {
                    answer += Integer.parseInt(str);
                }
            }
        }

        return answer;
    }

    public boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}