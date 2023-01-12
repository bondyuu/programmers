import java.util.*;

class Solution {
    public int solution(String dirs) {
        String[] dirArr = dirs.split("");

        int[] start = {0,0};
        Map<String, Integer> map = new HashMap<>();
        for (String dir: dirArr) {
            int[] des = getDes(start, dir);

            if(isNotValidPosition(des)) {
                continue;
            }

            String path = Arrays.toString(start)+":"+Arrays.toString(des);
            String reversePath = Arrays.toString(des)+":"+Arrays.toString(start);
            System.out.println(path);
            if (!map.containsKey(path) && !map.containsKey(reversePath)){
                map.put(path,1);
            }

            start = des;
        }
//        System.out.println(map);
        return map.size();
    }

    public int[] getDes(int[] start, String dir) {
        int[] des = new int[2];

        switch (dir) {
            case "U":
                des[0] = start[0];
                des[1] = start[1]+1;
                break;
            case "D":
                des[0] = start[0];
                des[1] = start[1]-1;
                break;
            case "L":
                des[0] = start[0]-1;
                des[1] = start[1];
                break;
            case "R":
                des[0] = start[0]+1;
                des[1] = start[1];
        }

        return des;
    }

    public boolean isNotValidPosition(int[] position) {
        if(position[0]>5 || position[0]<-5) {
            return true;
        }
        if(position[1]>5 || position[1]<-5) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("LULLLLLLU"));
    }
}