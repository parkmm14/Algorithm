### 1966 프린터 큐

https://www.acmicpc.net/problem/1966

 우선순위, 인덱스를 큐 구성 요소로 잡고 출력가능한 대상 조건을 비교.

출력대상 조건 중 하나 - 큐에 존재하는 프린터 중 우선순위가 가장 높아야 되므로 

조건 비교를 위해 우선순위 정보를 내림차순으로 정렬한 배열 이용

```java
import java.util.*;
import java.io.*;

//큐 객체 타입 구성 요소로 우선순위, 인덱스 선언
class QInfo {
    int priority, idx;
    public QInfo(int prior, int idx) {
        this.priority = prior;
        this.idx = idx;
    }
}

public class Main{
    
    static int t, n, target_idx;
    static Queue<QInfo> q;
    static Integer[] arr;
    
     public static void main(String []args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        
        t = Integer.parseInt(br.readLine());
        
        //tc 개수만큼 반복 수행 
        for(int tc = 0; tc < t; tc++) {
            q = new LinkedList<QInfo>();
            str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            target_idx = Integer.parseInt(str[1]);
            arr = new Integer[n];
            str = br.readLine().split(" ");
            for(int i = 0; i < n; i++ ){
                arr[i] = Integer.parseInt(str[i]);
                q.add(new QInfo(arr[i], i));
            }
            //우선순위가 높은 순으로 프린터 배치
            Arrays.sort(arr, Collections.reverseOrder());
            
            int i = 0, cnt = 0;
            
            while(true) { //타겟 인덱스출력 못하는 경우 없으니까 true로 설정.
               QInfo qinfo = q.poll();       
               //큐에서 꺼낸 데이터가 출력 대상(현시점 가장 높은 우선순위)과 일치하는지 비교
               if(qinfo.priority == arr[i]) {
                    //target index까지 일치하는지 비교
                   if(qinfo.idx == target_idx) {
                       System.out.println(cnt + 1);
                       break;
                   }
                   //찾고자 하는 target index는 아니면 
                   else{
                       cnt+=1;
                       i+=1;
                   }
               }
               //현시점 출력대상이 아니면 큐 맨 뒤에 삽입.
               else{
                   q.add(new QInfo(qinfo.priority, qinfo.idx));
               }
            }
        }
     }
}
```

