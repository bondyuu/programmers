import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();

        s = s.substring(2,s.length()-2);
        String[] arr = s.replace("},{","-").split("-");
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                }
                return -1;
            }
        });
//        System.out.println(Arrays.toString(arr));

        for(String str: arr) {
            String[] arr2 = str.split(",");

            for(String str2: arr2){
                if (!answer.contains(Integer.parseInt(str2))) {
                    answer.add(Integer.parseInt(str2));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
        System.out.println(sol.solution("{{20,111},{111}}"));
        System.out.println(sol.solution("{{123}}"));
        System.out.println(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
}