#### 타겟 넘버

https://programmers.co.kr/learn/courses/30/lessons/43165



Sol) 상태 트리 상, 각 numbers 원소에 대해 경우의 수는 2가지 (더하거나, 빼거나 둘 중 하나)

​		종료조건 :  트리의 Level 

​						  && total == target

#### 1. dfs 풀이

(1) solution 함수 안에 dfs 함수 선언과 호출 ---> `nonlocal` 키워드 사용

``` python
def solution(numbers, target):
   
    n = len(numbers)
    cnt = 0
    def dfs (L, total):
        if L==n:
            if total == target:
                nonlocal cnt
                cnt += 1
                return cnt
            else: return
               
        else:
            dfs(L + 1, total + numbers[L])
            dfs(L + 1, total - numbers[L])
        
    
    dfs(0,0)    
    return cnt 
```



(2) solution 함수와는 별도로 dfs함수 선언 `global` 키워드 사용해서 전역변수로 이용.

``` python
answer = 0
def dfs(numbers, target, L, total):
    global answer
    if L == len(numbers):
        if total == target:
            answer += 1
            return answer
        else: return
    else:
        dfs(numbers, target, L + 1, total + numbers[L])
        dfs(numbers, target, L + 1, total - numbers[L])
    


def solution(numbers, target):
    global answer
    dfs(numbers, target, 0, 0)
    return answer
```



#### 2. bfs 풀이

bfs는 너비 우선 탐색 ---->선입선출인 큐를 이용해서 트리 구조상 가로 방향으로 수행! 

dfs, bfs 는 항상 트리를 생각해서 풀기(그림 그려서 이해하면 쉬움)

종료조건은 level에 도달 (+ 문제의 조건)



`collections.deque` 이용하기 위해 	`import collections `  

여기서 deque 초기화 할때 deq = collections.deque[(요소, 요소)] 

deque 에 요소 추가할 때 deq.append((요소, 요소)) ----> packing , unpacking 문법 주의

dfs와 bfs의 차이 ---> 탐색 방향이 깊이(아래로))냐 너비(옆으로)냐임. 둘 다 Level 이용, 결국 결과적으론 모든 요소를 다 방문함.



``` python
import collections
answer = 0
def bfs (numbers, target):
    deq = collections.deque([(0,0)])
    global answer
    while(deq):
        idx, total = deq.popleft() 
        
        if (idx == len(numbers)):
            if (total == target): answer += 1
        
        else:
            number = numbers[idx]
            deq.append((idx + 1, total + number))
            deq.append((idx + 1, total - number))
     
    return answer

def solution(numbers, target):
    
    bfs(numbers, target)
    return answer
```



