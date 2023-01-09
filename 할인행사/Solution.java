import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
            sum += number[i];
        }

        Discount discountCls = new Discount(discount);
        for (int i = 0; i <= discount.length - sum; i++){

            if(wantMap.equals(discountCls.getList(i, i + sum))){
                answer++;
            }
        }

        return answer;
    }


    public static class Discount {
        private String[] discount;

        public Discount(String[] discount) {
            this.discount = discount;
        }

        public Map<String, Integer> getList(int start, int end){
            Map<String, Integer> list = new HashMap<>();

            for (int i = start; i < end; i++){
                if(list.containsKey(discount[i])){
                    list.replace(discount[i], list.get(discount[i]) + 1);
                } else {
                    list.put(discount[i], 1);
                }
            }

            return list;
        }

    }
}