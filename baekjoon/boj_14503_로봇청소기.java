package boj;
import java.util.*;
import java.io.*;


public class boj_14503_로봇청소기 {
	//왼쪽방향으로 회전
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	//북 동 남 서 순
	
	static int[][] map;
	static boolean[][] visited;
	static int n,m, r, c, d;
	static int cnt=0;
	
	public static void dfs(int y, int x, int d) {
		
	visited[y][x] = true;	
	cnt+=1;
	
	d = (d+ 3) % 4;
	
	for(int i=0; i<4; i++) {
		d = (d+ 3) % 4;
		int nr = y + dr[d];
		int nc = x + dc[d];
		
		if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
		 if(!visited[nr][nc] && map[nr][nc] == 0) {
			dfs(nr, nc, d);
			return;
			}
		  }
		 }
		int back = (d + 2) % 4;
		int backY = y + dr[back];
		int backX = x + dc[back];
		if(backY >= 0 && backX >= 0 && backY < n && backX < m && !visited[backY][backX]) {
		dfs(backY, backX, d);
		}
	
	
	}
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		 r = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());
		 d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; i < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		dfs(r, c, d);
		System.out.println(cnt);
		
	}

}
