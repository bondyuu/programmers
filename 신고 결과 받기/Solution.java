import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> rpt = Arrays.stream(report).collect(Collectors.toSet());
        Map<String, ArrayList<String>> tbl = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        for (String id : id_list){
            tbl.put(id, new ArrayList<String>());
            cntMap.put(id, 0);
        }



        for (String re : rpt){
            String id = re.split(" ")[0];
            ArrayList<String> newlist = tbl.get(id);

            String str = re.split(" ")[1];

            newlist.add(str);
            tbl.replace(id, newlist);
            cntMap.replace(str, cntMap.get(str) +1);


        }



        for(int i = 0; i < id_list.length; i++){
            ArrayList<String> values = tbl.get(id_list[i]);

            for(String value : values){
                if (cntMap.get(value)>=k){
                    answer[i]++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        System.out.println(Arrays.toString(solution(id_list2, report2, k2)));

    }
}