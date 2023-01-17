import java.util.*;

class Solution {

    class Song {
        int idx;
        String genre;
        int play;

        public Song(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {


        List<Song> songList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
            songList.add(new Song(i, genres[i], plays[i]));
        }

        songList.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (map.get(o1.genre) < map.get(o2.genre)) {
                    return 1;
                } else if(map.get(o1.genre).equals(map.get(o2.genre))) {
                    if (o1.play < o2.play) {
                        return 1;
                    } else if (o1.play == o2.play){
                        return Integer.compare(o1.idx, o2.idx);
                    }
                }
                return -1;
            }
        });
//        songList.stream().forEach(e -> System.out.println(e.idx));
//        System.out.println("-----------------------------------");


        List<Song> result = new ArrayList<>();
        Map<String, Integer> chkMap = new HashMap<>();
        int k = 1;
        String str = "";
        for (Song song : songList) {
            if (song.genre.equals(str)) {
                k++;
            } else {
                str = song.genre;
                k = 1;
            }
            if (k <= 2) {
                result.add(song);
            }
        }

//        result.stream().forEach(e -> System.out.println(e.idx));

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i).idx;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }
}