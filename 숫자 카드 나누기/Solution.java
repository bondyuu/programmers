import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Integer> listA = getList(arrayA[0], arrayA);


        int a = getMax(listA, arrayB);

        List<Integer> listB = getList(arrayB[0], arrayB);
        int b = getMax(listB, arrayA);


        return Math.max(a,b);
    }

    public int getMax(List<Integer> list, int[] arr) {
        int rtn = 0;

        for (int num: list) {
            boolean add = true;
            for (int p : arr) {
                if (p % num == 0) {
                    add = false;
                }
            }
            if (add && num > rtn) {
                rtn = num;
            }
        }
        return rtn;
    }

    public List<Integer> getList(int k, int[] arr) {
        List<Integer> list = new ArrayList<>();

        outer:
        for (int i = 2; i <= k; i++) {
            if (k % i == 0) {
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j] % i != 0){
                        continue outer;
                    }
                }
                list.add(i);
            }
        }
        return list;
    }

}