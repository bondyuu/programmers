import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, User> map = new HashMap<>();

        initialSetting(enroll, referral, map);

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            User user = map.get(name);
            int mySales = amount[i] * 90;
            user.setSales(mySales);

            int upSales = amount[i] * 10;
            while (!user.up.getName().equals("center") && upSales >= 1) {
                user.up.setSales(upSales - upSales/10);
                upSales /= 10;
                user = user.up;
            }

        }

        for (int i = 0; i < enroll.length; i++) {
            User user = map.get(enroll[i]);

            answer[i] = user.sales;
        }

        return answer;
    }

    public void initialSetting(String[] enroll, String[] referral, Map<String, User> map) {
        map.put("center", new User("center"));
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            map.put(name, new User(name));
        }

        for (int i = 0; i < enroll.length; i++) {
            User user = map.get(enroll[i]);

            //나를 추천해준 사람 설정
            if (referral[i].equals("-")) {
                user.setUp(map.get("center"));
            } else {
                user.setUp(map.get(referral[i]));
            }

        }
    }

    class User {
        private String name;
        private int sales;
        private User up;

        public User() {
        }

        public User(String name) {
            this.name = name;
            this.sales = 0;
        }

        public String getName() {
            return this.name;
        }

        public void setSales(int num) {
            this.sales += num;
        }

        public void setUp(User user) {
            this.up = user;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //                  400     1000                     500                200     1200
        //                  360      910                     450                180     1080
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        //                   4       10                        5                 2       12
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(sol.solution(enroll, referral, seller, amount));
    }
}