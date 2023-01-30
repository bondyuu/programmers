class Solution {
    public String[] solution(String my_str, int n) {
        int len;
        if (my_str.length()%n ==0) {
            len = my_str.length()/n;
        } else {
            len = my_str.length()/n + 1;
        }
        String[] answer = new String[len];

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                answer[i] = my_str.substring(n*i);
            } else {
                answer[i] = my_str.substring(n*i, n*(i+1));
            }
        }

        return answer;
    }
}