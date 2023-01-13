import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(String term: terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }


        for (int i = 0; i < privacies.length; i++) {
            String[] start = privacies[i].split(" ")[0].split("\\.");

            int period = map.get(privacies[i].split(" ")[1]);

            int endMonth = Integer.parseInt(start[1]) + period;

            if (endMonth > 12) {
                start[0] = String.valueOf(Integer.parseInt(start[0]) + endMonth/12);
                start[1] = String.valueOf(endMonth - (endMonth/12)*12);
            } else {
                start[1] = String.valueOf(endMonth);
            }

            if(start[1].length() == 1) {
                start[1] = "0" + start[1];
            }

            String end = start[0] + "." + start[1] +"." + start[2];


            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date date2 = format.parse(end);
            Date date1 = format.parse(today);

            if (date1.compareTo(date2)>=0) {
                answer.add(i+1);
            }

        }
        return answer;
    }

    public static void main(String[] args) throws ParseException {
        Solution sol = new Solution();

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(sol.solution(today, terms, privacies));
    }
}