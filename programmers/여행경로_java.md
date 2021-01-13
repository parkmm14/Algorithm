### 여행경로

https://programmers.co.kr/learn/courses/30/lessons/43164

이 문제는 bfs보다 dfs로 푸는게 더 나을 것 같다고 생각하긴 했지만 오기로 bfs로 풀다가 너무 복잡해져서 관둠.. 삽질했다;

dfs로 풀면 훨씬 쉬운 문제임

#### (Java)

```java
import java.util.*;


class Solution {
    
    public static boolean[] visited;
    public static ArrayList<String> answers;
    
    
    public void dfs(int cnt, String present, String answer, String[][] tickets){
        	// 모든 도시를 방문할 수 없는 경우는 없기 때문에 주어진 도시 수만큼 방문했을 때가 종료 조건임.
        if (cnt == tickets.length){
            answers.add(answer);
            return;
        }
        
        for (int i = 0; i< tickets.length; i++) {
    
                if (!visited[i] && tickets[i][0].equals(present)){//방문 아직 안했고, 현재 티켓의 출발 공항일 때 방문
                    visited[i] = true; /
                    dfs(cnt + 1, tickets[i][1], answer + " " + tickets[i][1],tickets);
                  	//또다른 경우의 수에 대한 계산을 위해 방문 초기화
                    visited[i] = false; 
                }
            }
    }
    public String[] solution(String[][] tickets) {
        
        answers = new ArrayList<String>();
        
        visited = new boolean[tickets.length];
        
        int cnt = 0;
        
        dfs(cnt, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
        
    }
}
```

