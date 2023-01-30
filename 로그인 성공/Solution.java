class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for (String[] arr: db) {
            if (arr[0].equals(id_pw[0]) && arr[1].equals(id_pw[1])) {
                return "login";
            } else if (arr[0].equals(id_pw[0]) && !arr[1].equals(id_pw[1])) {
                return "wrong pw";
            }
        }
        return answer;
    }
}