### 1012 유기농배추

https://www.acmicpc.net/problem/1012

너비(시작 노드로부터 가까운 노드부터 확인해서 전체 노드를 모두 확인 및 방문.) 

상하좌우 인접한 노드들 먼저 방문--->bfs 

```java
import java.util.*;
import java.io.*;

class Dot {
    int y, x;
    public Dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


public class Main{
    
    static Queue<Dot> q;
    static int t, m, n, k;
    static int[][] map;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void bfs() {
        
        while(!q.isEmpty()){
            Dot dot = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = dot.y + dr[i];
                int nc = dot.x + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(map[nr][nc] != 1) continue;
                q.add(new Dot(nr,nc));
                map[nr][nc] = 2;
                }
            }
    }
    
     public static void main(String []args)  throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] str;
         t = Integer.parseInt(br.readLine());
         //테이스 케이스 수 만큼 반복 (tc 마다 큐, 배열, cnt값 등 초기화 해야 함을 주의 )
         for(int tc = 0; tc < t; tc++) {
              q = new LinkedList<Dot>();
             //가로, 세로, 심어진 배추의 위치 개수 입력 받기
             str = br.readLine().split(" ");
             m = Integer.parseInt(str[0]);
             n = Integer.parseInt(str[1]);
             k = Integer.parseInt(str[2]);
             
             map = new int[n][m];
             
             //배추 좌표 입력
             for(int i=0; i<k; i++) {
                 str = br.readLine().split(" ");
                 map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
             }
             
             int cnt = 0;
             
             for(int i = 0; i< n; i++) {
                 for(int j = 0; j < m; j++) {
                     if(map[i][j] != 1) continue;
                     q.add(new Dot(i,j));
                     bfs();
                     cnt+=1;
                 }
             }
             System.out.println(cnt);
             
         }
        
     }
}
```

