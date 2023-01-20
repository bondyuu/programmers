import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int k : array) {
            map.put(k,map.getOrDefault(k,0)+1);
            if (!list.contains(k)) {
                list.add(k);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        if (list.size() == 1){
            return list.get(0);
        }

        if (map.get(list.get(0)) == map.get(list.get(1))) {
            return -1;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] array = {1, 1, 2, 2};
        System.out.println(sol.solution(array));
    }
}