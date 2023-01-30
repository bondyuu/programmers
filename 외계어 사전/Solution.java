class Solution {
    public int solution(String[] spell, String[] dic) {

        for (String str: dic) {
            boolean canMake = true;
            for (String s: spell) {
                if (!str.contains(s)) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) {
                return 1;
            }
        }

        return 2;
    }
}