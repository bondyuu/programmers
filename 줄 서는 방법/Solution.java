import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        k--;
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        List<Long> fac = new ArrayList<>();
        fac.add(1L);

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac.add(fac.get(i-1) *i);
        }

        for (int i = n-1; i >= 0; i--){
            long f = fac.get(i);  //6  2 1
            int idx = (int) (k/f);  //3  2 1
            k = k % f; //5  1  0
            answer[n-1-i] = list.get(idx);
            list.remove(idx);
        }

        return answer;
    }

}