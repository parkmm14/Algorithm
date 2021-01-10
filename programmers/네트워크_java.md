### 네트워크



https://programmers.co.kr/learn/courses/30/lessons/43162



풀이)

재귀, 즉 stack의 원리를 이용하는 dfs로 풀었다.

간접연결까지 포함해 하나의 연결로 간주하므로 방문하지 않은 컴퓨터(=노드)를 대상으로 dfs로

연결된 모든 컴퓨터를 확인한다. 

방문하지 않은 노드에 대하여 직, 간접 연결된 노드들을 모두 방문한 후(더 이상 체크할 노드가 없을때까지 dfs호출), count +1 증가 

Dfs는 무한루프에 걸리지 않게 종료 조건이 중요한데 이 문제는 최대 n만큼 호출될 것이기 때문에 (반복문이 최대 n까지니까)

return 조건을 명시하지 않아도 됨.

그리고 불필요한 호출, 실행을 막기 위해 방문한 노드 체크가 중요!

python이 코드가 단순한 장점때문에 최근에 이용하고 있는데, 주언어로  java를 오래 사용해서 아직까진 Java 구현이 더 편하당.. bfs 풀이도 생각해보긴 했는데 이 문제는 n의 개수가 크지 않으니까 그냥 dfs로 했다.

#### (JAVA)

``` java
class Solution {
    public static boolean[] visited;
    
    
    public void dfs(int v, int[][] computers){
        
        visited[v] = true;
        
        for(int i=0; i<computers.length; i++) {
            if(computers[v][i] == 1  && v!=i &&!visited[i]){
                dfs(i, computers);
               
            }
        }
        
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
            
            if(!visited[i]) {
                dfs(i, computers);
                answer+=1;
                
            }
                
        }
        }
        
        return answer;
    }
}
```



