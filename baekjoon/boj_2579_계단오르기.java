package boj;

import java.util.*;
import java.io.*;

public class boj_2579_계단오르기 {
	
	static Integer[] dp;
	static int[] arr;
	
	
	//top-down + bufferedReader
	public static int find (int N) {
		//아직 탐색하지 않은 계단일 경우
		if(dp[N] == null) {
			dp[N] = Math.max(find(N-2), find(N-3) + arr[N - 1])+ arr[N];
		}
		return dp[N];
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new Integer[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		if(N >= 2) {
		dp[2] = arr[1] + arr[2];
		}
		System.out.println(find(N));
	}
}
