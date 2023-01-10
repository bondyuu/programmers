class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i) + s.substring(0,i);
            if (validBracket(str)){
                answer++;
            }
        }
        return answer;
    }

    public boolean validBracket(String str) {

        while(true){
            if(str.equals("")) {
                return true;
            }

            if(str.contains("()")){
                str =str.replace("()","");
                continue;
            } else if (str.contains("{}")){
                str = str.replace("{}","");
                continue;
            } else if (str.contains("[]")){
                str = str.replace("[]","");
                continue;
            }

            return false;

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
    }
}