import java.util.*;


class Solution {
    public static int solution(int[] cards) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++){
            map.put(i+1, cards[i]);
        }

        List<Integer> stages = new ArrayList<>();
        int p = 1;
        while(!map.isEmpty()) {
            stages.add(stage(map));
            if(p == 1 && map.isEmpty()){
                return 0;
            }
            p++;
        }
        Collections.sort(stages, Collections.reverseOrder());

        answer = stages.get(0) * stages.get(1);

        return answer;
    }

    public static int stage(Map<Integer, Integer> map) {
        int answer =0;
        if (map.size() == 0) {
            return 0;
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        int i = (Integer) keys[0];
//        System.out.println("key : " + i);
        while (map.containsKey(i)) {
            int k = i;
            i = map.get(k);
            map.remove(k);

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println("sol : " + solution(cards));
    }

}