import java.util.*;

class Solution {

    int X;
    int Y;
    public int solution(int[][] maps) {
        X = maps.length - 1;
        Y = maps[0].length - 1;

        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;

        Deque<List<int[]>> dq = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        int[] start = new int[] {0,0};
        list.add(start);
        dq.offer(list);

        while (dq.size()!=0) {

            List<int[]> stage = dq.poll();
            List<int[]> nextList = new ArrayList<>();
            for (int[] point: stage) {

                int x = point[0];
                int y = point[1];


                if(canMove(x,y,-1,0,maps,visited)) {
                    nextList.add(new int[] {x-1,y});
                    visited[x-1][y] = visited[x][y] +1;
                }
                if(canMove(x,y,1,0,maps,visited))  {
                    nextList.add(new int[] {x+1,y});
                    visited[x+1][y] = visited[x][y] +1;
                }
                if(canMove(x,y,0,-1,maps,visited)) {
                    nextList.add(new int[] {x,y-1});
                    visited[x][y-1] = visited[x][y] +1;
                }
                if(canMove(x,y,0,1,maps,visited))  {
                    nextList.add(new int[] {x,y+1});
                    visited[x][y+1] = visited[x][y] +1;
                }

            }

            if(!nextList.isEmpty()){
                dq.offer(nextList);
            }

        }

        int answer = visited[X][Y];
        if(answer==0){
            return -1;
        }

        return answer;
    }

    public boolean canMove(int x, int y, int dx, int dy, int[][] maps, int[][]visited) {
        int a = x + dx;
        int b = y + dy;

        if (a>X || a<0) {
            return false;
        }
        if (b>Y || b<0) {
            return false;
        }

        return maps[a][b] == 1 && visited[a][b] == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(sol.solution(maps));
    }
}