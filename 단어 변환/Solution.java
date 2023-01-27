import java.util.*;

class Solution {

    boolean[] check;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        check = new boolean[words.length];
        answer = bfs(begin, target, words);

        return answer;
    }

    public boolean isSimilar(String a, String b) {

        for (String k : a.split("")) {
            b = b.replaceFirst(k,"");
        }

        return b.length() == 1;
    }

    public int bfs(String begin, String target, String[] words) {
        Queue<List<String>> queue = new LinkedList<>();

        queue.offer(Collections.singletonList(begin));

        int i = 0;
        while (!queue.isEmpty()) {
            if (i > words.length) {
                return 0;
            }
            List<String> stage = queue.poll();

            List<String> list = new ArrayList<>();
            for (String str: stage) {
                if (str.equals(target)) {
                    return i;
                }

                for (int j = 0; j < words.length; j++) {
                    if (isSimilar(str, words[j]) && !check[j]) {
                        list.add(words[j]);
                        check[j] = true;
                    }

                }

            }
            if (!list.isEmpty()) {
                queue.offer(list);
            }
            i++;
        }


        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words = {"abb", "aba"};
        System.out.println(sol.solution("aab", "aba", words));
    }
}