import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2 {
    int[] visit;
    int K;
    String number;
    PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
    public String solution(String number, int k) {
        String answer = "";

        visit = new int[number.length()];
        K = k;
        this.number = number;
        dfs("",0);

        return pq.peek();
    }

    public void dfs(String str, int idx) {
        if (idx == K) {
            StringBuffer value = new StringBuffer(number);
            String[] arr = str.split("");
            Arrays.sort(arr, Comparator.reverseOrder());
            for(String index: arr) {
                int num = Integer.parseInt(index);
                value.delete(num, num+1);
            }
            pq.offer(value.toString());
        }

        for (int i = 0; i < number.length(); i++) {
            if (visit[i] == 0) {
                String next = str + String.valueOf(i);
                visit[i] = 1;
                dfs(next, idx+1);
                visit[i] = 0;
            }
        }


    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println(sol.solution("4177252841"	,4));
    }
}