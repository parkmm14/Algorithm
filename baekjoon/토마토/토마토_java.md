### 토마토

https://www.acmicpc.net/problem/7576

전형적인 bfs 문제

``` java
import java.util.*;
import java.io.*;

class Pos{
	int y, x, day;
	
	public Pos(int y, int x, int day) {
		this.y = y;
		this.x =x ;
		this.day = day;
	}
}
public class Main {
	
	
	
	static int m,n;
	static int[][] map;
	static int zero;
	static Queue<Pos> q = new LinkedList<>();
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int bfs()  {
		//심어진 토마토 없으면 day 0 리턴 
		if(zero==0) return 0;
		
    
		while(!q.isEmpty()) {
			Pos tomato = q.poll();
			
			
			for(int i=0; i<4; i++) {
				int nr = tomato.y + dr[i];
				int nc = tomato.x + dc[i];
				if(nr < 0 || nr >=n || nc<0 || nc>=m) continue;
				if(map[nr][nc] == 0) {
					q.add(new Pos(nr,nc,tomato.day + 1));
					map[nr][nc] = tomato.day + 1;
					zero-=1;
					
			} //심어진 토마토가 모두 자라났으면 최소일수 리턴
				if(zero==0) return map[nr][nc];
				
			}
			
		}
	
		//못 자라난 토마토 존재하면 -1 리턴
		return -1;
	}
	
	public static void main (String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new Pos(i,j,0));
		
				}
				if(map[i][j] == 0) {
					zero++;
				}
				
			}
		}
		
		int day = bfs();
		System.out.println(day);
		
	}
}
```

