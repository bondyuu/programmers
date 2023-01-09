import java.util.*;

class Solution {


    public static int solution(int[] elements) {

        Set<Integer> sumSet = new HashSet<>();

        for (int i = 1; i <= elements.length; i++){
            List<Integer> sumList = getSumList(elements, i);
            System.out.println(sumList.toString());
            sumSet.addAll(sumList);
        }

        return sumSet.size();
    }

    public static List<Integer> getSumList(int[] elements, int idx) {
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < elements.length; i++){
            for(int j =0; j<idx; j++){
//                System.out.println("i : "+ i);
//                System.out.println("j : "+ j);
                int k = (i + j)% elements.length;
                sum += elements[k];
            }
            sumList.add(sum);
            sum = 0;
        }
        return sumList;
    }

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }
}