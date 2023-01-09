import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.add('(');
            } else{
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return answer;
    }
}