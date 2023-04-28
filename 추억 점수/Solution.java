import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Person> map = new HashMap<>();
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], new Person(name[i], yearning[i]));
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = calTotalPoint(photo[i]);
        }


        return answer;
    }

    public int calTotalPoint(String[] photo) {
        int sum = 0;

        for (String name: photo) {
            if (map.containsKey(name)) {
                sum += map.get(name).point;
            }
        }

        return sum;
    }

    class Person {
        String name;
        int point;

        public Person(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(sol.solution(name, yearning, photo)));
    }
}