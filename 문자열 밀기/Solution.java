class Solution {
    public int solution(String A, String B) {
        int answer = -1;

        if(A.equals(B)) {
            return 0;
        }

        for (int i = 1; i < A.length(); i++){
            if (B.equals(rotate(A, i))) {
                return i;
            }
        }

        return answer;
    }

    public String rotate(String str, int i) {

        return str.substring(str.length()-i) + str.substring(0,str.length()-i);
    }


}