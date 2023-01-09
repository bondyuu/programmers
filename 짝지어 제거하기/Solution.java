import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] list = s.split("");
        Stack<String> stack = new Stack<>();

        for(String str: list) {
            if(stack.isEmpty()){
                stack.push(str);
                continue;
            }
            if(stack.peek().equals(str)){
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty()?1:0;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abccba";
        System.out.println(sol.solution(s));
    }
}