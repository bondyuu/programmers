import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();

        Map<String, String> idMap = new HashMap<>();

        for (String event: record) {
            String call = event.split(" ")[0];

            String result = "";
            try {
                Class[] parType = new Class[2];
                parType[0] = String.class;
                parType[1] = Map.class;
                result = (String) Solution.class.getDeclaredMethod(call, parType).invoke(this, event, idMap);
            } catch (Exception e) {
                System.out.println(e);
            }

            if (!result.equals("")) {
                list.add(result);
            }

        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String id = str.split("님")[0];
            answer[i] = str.replace(id, idMap.get(id));
        }

        return answer;
    }

    public String Enter(String event, Map<String, String> idMap) {
        String[] arr = event.split(" ");
        idMap.put(arr[1], arr[2]);
        return arr[1]+"님이 들어왔습니다.";
    }

    public String Leave(String event, Map<String, String> idMap) {
        String[] arr = event.split(" ");
        return arr[1]+"님이 나갔습니다.";
    }

    public String Change(String event, Map<String, String> idMap) {
        String[] arr = event.split(" ");
        idMap.put(arr[1], arr[2]);
        return "";
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(sol.solution(records)));
    }
}