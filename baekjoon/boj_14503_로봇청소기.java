package boj;
import java.util.*;
import java.io.*;

public class boj_14503_로봇청소기 {
	static int[][] map;
	//북 동 남 서 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int n,m, ans=0;
	
	public static void clean (int y, int x, int d) {
		//이 조건 없으면 벽에서 조건을 탐색하게 되는 엉뚱한 루트로 빠지게 되므로 벽이면 돌아가줘야 함(==리턴)
		// 외곽이 벽으로 둘러싸여 있으므로 벽일때 리턴해주니까 영역 검사 불필요.
		if(map[y][x] == 1) return;
		
		if(map[y][x] == 0) {
			ans++;
			map[y][x] = -1;
		}
		for(int i = 0; i < 4; i++) {
			//왼쪽부터 총4방향 계산이니까 방향은 누적 계산 
			d = (d + 3)%4;
		    int newY = y + dr[d];
			int newX = x + dc[d];
			if(map[newY][newX] == 0) {
				clean(newY, newX, d);
				return;
			 }
		   }
		int back = (d + 2) % 4;
		int backY = y + dr[back];
		int backX = x + dc[back];
		// "현재 방향을 유지한 채 후진"은 clean(y - nr[d], x - nc[d],d) 로도 표현 가능. 
		clean(backY, backX, d);
		return;
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		
		clean(y, x, d);
		System.out.println(ans);
		
	}

}
