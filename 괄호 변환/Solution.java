import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.equals("") || isCorrect(p)) {
            return p;
        }

        String u = parse(p)[0];
        String v = parse(p)[1];
        if (isCorrect(u)) {
            return u + solution(v);
        }

        String temp = "(" + solution(v) + ")";
        String k = reverse(u.substring(1,u.length()-1));
        temp += k;

        return temp;
    }

    public String[] parse(String p) {
        String[] arr = new String[2];

        String u = "";
        String v = "";

        for (int i = 2; i <= p.length(); i += 2) {
            if (isBalance(p.substring(0,i))) {
                u = p.substring(0,i);

                if (i<p.length()){
                    v = p.substring(i);
                } else {
                    v= "";
                }
                break;
            }
        }
        arr[0] = u;
        arr[1] = v;

        return arr;
    }

    public boolean isBalance(String str) {
        int[] arr = new int[2];
        for (char c : str.toCharArray()){
            if (c == '(') {
                arr[0]++;
            } else {
                arr[1]++;
            }
        }
        return arr[0]==arr[1];
    }

    public boolean isCorrect(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String t = String.valueOf(str.charAt(i));

            if (stack.isEmpty()) {
                stack.push(t);
            } else {
                if (stack.peek().equals("(") && t.equals(")")) {
                    stack.pop();
                } else {
                    stack.push(t);
                }
            }
        }

        return stack.isEmpty();
    }

    public String reverse(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                answer += ")";
            } else {
                answer += "(";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("()))((()"));
    }
}