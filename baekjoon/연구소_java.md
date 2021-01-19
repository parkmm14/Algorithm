14502 연구소

https://www.acmicpc.net/problem/14502

벽 세우기는 dfs, 바이러스 퍼뜨리기는 bfs 이용.

3개의 벽을 세운 상태의 맵을 카피한 또다른 맵에서 바이러스 퍼뜨림 --> 케이스마다 바이러스 퍼뜨리고 안전영역을 카운트해아하기 때문.(바이러스가 퍼지기 전인 기존 맵 재사용하여)

``` java
import java.util.*;
import java.io.*;

class Dot {
    int y, x;
    public Dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

//n*m개 중에서 3개를 뽑는 모든 경우의 수(조합) -->  백트래킹 기법 이용.
public class Main{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    
    static int[][] origin, map;
    static int n,m;
    static ArrayList<Dot> virus = new ArrayList<>();
    static int sol = 0;
    
    public static void dfs(int start, int cnt) {
        
        if(cnt == 3) {
            Queue<Dot> q = new LinkedList<Dot>();
            for(int i = 0; i < virus.size(); i++) {
                q.add(virus.get(i));
            }
            
            for(int i = 0; i < n*m; i++) {
                map[i/m][i%m] = origin[i/m][i%m];
            }
            
            while(!q.isEmpty()){
                Dot d = q.poll();
                
                for(int i = 0; i < 4; i++) {
                    int nr = d.y + dr[i];
                    int nc = d.x + dc[i];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(map[nr][nc] == 0) {
                        map[nr][nc] = 2;
                        q.add(new Dot(nr,nc));
                     
                    }
                }
        }
        int safty_zone=0;
        for(int i = 0; i< n*m; i++) {
            if(map[i/m][i%m] == 0) safty_zone+=1;
        }
        sol = Math.max(safty_zone, sol);
        return;
    }
    else{
    for(int i = start; i < n*m; i++) {
        if(origin[i/m][i%m] == 0) {
            origin[i/m][i%m] = 1;
            dfs(i + 1, cnt + 1);
            origin[i/m][i%m] = 0;
        
        }
     }
    }
    }
    

     
    public static void main(String []args) throws Exception{ 
   
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str;
    
    str = br.readLine().split(" ");
    n = Integer.parseInt(str[0]);
    m = Integer.parseInt(str[1]);
    
    origin = new int[n][m];
    map = new int[n][m];
    for(int i = 0; i < n; i++) {
        str = br.readLine().split(" ");
        for(int j = 0; j < m; j++) {
            origin[i][j] = Integer.parseInt(str[j]);
            //바이러스 좌표 저장
            if(origin[i][j] == 2) {
                virus.add(new Dot(i, j));
            }
        }
    }

   
    dfs(0, 0);
    System.out.println(sol);
    
    }
}
```



