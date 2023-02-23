import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        List<Integer> list = new ArrayList<>();
        for (int a: numlist) {
            list.add(a);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - n) > Math.abs(o2 - n)){
                    return 1;
                } else if (Math.abs(o1 - n) < Math.abs(o2 - n)){
                    return -1;
                } else {
                    return o2-o1;
                }
            }
        });
        System.out.println(list);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;

        System.out.println(Arrays.toString(sol.solution(numlist, n)));
    }
}