import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();


        for(int cour: course) {
            for (String order: orders) {
                dfs("",order,0, cour);
            }

            if (!map.isEmpty()) {
                List<Integer> list = new ArrayList<>(map.values());
                int max = Collections.max(list);

                for(String key: map.keySet()) {
                    
                    if (map.get(key).equals(max) && max > 1) {
                        ans.add(key);
                    }
                }
            }

            map.clear();
        }

        String[] answer = new String[ans.size()];
        for (int j = 0; j < answer.length; j++) {
            answer[j] = ans.get(j);
        }

        Arrays.sort(answer);
        return answer;
    }

    public void dfs(String str, String order, int depth, int len) {
        if (str.length() == len) {
            str = strAsc(str);

            map.put(str, map.getOrDefault(str,0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            dfs(str+String.valueOf(order.charAt(i)),order.substring(i+1), depth+1, len);

        }


    }

    public String strAsc(String str) {
        String ret = "";
        String[] arr = str.split("");
        Arrays.sort(arr);
        for (String a: arr) {
            ret += a;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course ={2,3,4};

        System.out.println(Arrays.toString(sol.solution(orders,course)));

    }
}