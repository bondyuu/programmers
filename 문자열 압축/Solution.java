class Solution {
    public int solution(String s) {
        String answer = s;
        String temp = "";

        for (int i = 1; i <= s.length()/2; i++) {
            //i= 자를 문자 갯수

            int k = 0;
            int num = 1;
            while (i * k + i <= s.length()) {
//                System.out.println("i : " + i + ", k : " + k);
//                int start = i*k;
//                int end = i*k+i;
//                System.out.println("start : " + start + ", end : " + end);
                String now = s.substring(i*k, i*k+i);
                if (i*(k+1)+i <= s.length() && now.equals(s.substring(i*(k+1), i*(k+1)+i))){
                    num++;
                } else {
                    System.out.println(num);
                    temp = temp.concat((num!=1?String.valueOf(num):""));
                    temp = temp.concat(now);
                    num = 1;
                }
                k++;
            }
            if (s.length() % i != 0){
                temp += s.substring(s.length()- (s.length() % i));
            }
            if (temp.length() < answer.length()) {
                answer = temp;

            }
            temp = "";
        }

//        System.out.println(answer);
        return answer.length();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("aaaaaaaaaab"));

    }
}