import java.util.*;

/*
*  베스트앨범의 수록 기준을 바탕으로 모든 노래를 정렬하면 되늰 문제. 자료구조를 이용하는 것이 핵심.
*  HashMap과 Comparator 사용법이 익숙해야 한다.
* */

class Solution {

    class Song implements Comparable<Song> {
        int id, play;
        String genre;

        Song(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            if(this.play == o.play) {
                return this.id - o.id;
            } else {
                return -(this.play - o.play);
            }
        }
    }
    ArrayList<Integer> bestAlbum;
    ArrayList<Song> songList;
    HashMap<String, Integer> genreMap;
    HashMap<String, Integer> albumMap;

    public int[] solution(String[] genres, int[] plays)  {
        bestAlbum = new ArrayList<>();
        songList = new ArrayList<>();
        genreMap = new HashMap<>();
        albumMap = new HashMap<>();

        for(int i = 0; i < genres.length; ++i) {
            int id = i;
            int play = plays[i];
            String genre = genres[i];

            songList.add(new Song(id, play, genre));

            if(genreMap.containsKey(genre)){
                genreMap.put(genre, genreMap.get(genre) + play);
            }
            else{
                genreMap.put(genre, play);
            }


        }

        Collections.sort(songList, new Comparator<Song>(){
            @Override
            public int compare(Song s1, Song s2) {
                if(s1.genre.equals(s2.genre)) {
                    return s1.compareTo(s2);

                }
                else {
                    return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
                }
            }
        });

        for(Song song : songList) {
            if(!albumMap.containsKey(song.genre)){
                albumMap.put(song.genre, 1);
                bestAlbum.add(song.id);
            }
            else {
                int genreCnt = albumMap.get(song.genre);

                if(genreCnt >= 2) continue;
                else {
                    albumMap.put(song.genre, genreCnt + 1);
                    bestAlbum.add(song.id);
                }
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }
}