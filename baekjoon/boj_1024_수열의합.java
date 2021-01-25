package test;

import java.util.*;
import java.io.*;
import java.lang.*;
public class boj_1024_수열의합 {

		public static void main(String []args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String[] str = br.readLine().split(" ");
	        long N = Long.valueOf(str[0]);
	        long L = Long.valueOf(str[1]);
	        
	        boolean flag = false; 
	        
	        
	        while(L <= 100) {
	            long start = (N / L) - (L - 1) / 2;
	            System.out.println(start);
	            if(start < 0) break;
	            
			//a1~an항의 합 구하기. 주의! / 연산에서 소수점이하 무시되니까 (L/2) 이렇게 괄호쓰면 잘못된 답 얻어짐.
	            if((2*start + L - 1)*L/2 == N) {
	                for(long idx = 0; idx < L; idx++) {
	                    long num = start + idx;
	                    System.out.print(num + " ");
	                }
	                flag = true;
	                break;
	            }
	            L++;
	            
	        }
	        
	        if(flag == false) System.out.println(-1);
	        else System.out.println();
	        
	        
	     }
	}



