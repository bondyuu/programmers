import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    String[] user_id;
    String[] banned_id;
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;

        Set<String> set = new HashSet<>();
        dfs(set, 0);

        return answer.size();
    }

    public void dfs(Set<String> set, int idx) {
        if (idx == this.banned_id.length) {
            answer.add(new HashSet<>(set));
            return;
        }

        for (String user : user_id) {
            if (set.contains(user)) {
                continue;
            }

            if (isMatched(banned_id[idx], user)) {
                set.add(user);
                dfs(set, idx+1);
                set.remove(user);
            }
        }
    }

    public boolean isMatched(String ban, String user) {
        if (ban.length() != user.length()) {
            return false;
        }

        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            }
            if (ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1= {"*rodo", "*rodo", "******"};

        System.out.println(sol.solution(user_id1, banned_id1));

//        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id2 = {"fr*d*", "*rodo", "******", "******"};
//        System.out.println(sol.solution(user_id2, banned_id2));

    }
}