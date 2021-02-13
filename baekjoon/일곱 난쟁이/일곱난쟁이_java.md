### 일곱난쟁이

https://www.acmicpc.net/problem/2309

브루트포스 이용

``` java
import java.util.*;

public class Main {
    
	static int a, b;
	static boolean flag; //안쪽 for문 조건의 break문 밖의 for문도 동시에 탈출하기 위해 선언.
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		ArrayList<Integer> result = new ArrayList<>();
		int total = 0;

		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			total +=arr[i];
		}
	
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				// 전체합산 - (난쟁이가 아닌 두 명) = 100 임을 이용
        //제외될 2명 찾기
				if(total-(arr[i]+arr[j])==100) {
					a = arr[i];
					b = arr[j];
					flag = true;
                    break;
				}
				
			}
			if(flag==true) {
				break;
			}
			
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i] != a && arr[i] != b) {
				result.add(arr[i]);
			}
		}
		Collections.sort(result);
		for(int i=0; i<result.size(); i++) 
			System.out.println(result.get(i));
		
		
	}
}
```

