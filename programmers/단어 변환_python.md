### 단어 변환

https://programmers.co.kr/learn/courses/30/lessons/43163

풀이)

너비우선 탐색인 bfs로 풀었다. popleft()로 요소를 꺼내는 deque활용

트리를 그려보는게좋다.

현재 기준 노드에서 알파벳이 1개만 차이나는 노드들을 큐에 모두 집어 넣고, 불필요한 재방문을 막기 위해 방문 체크.

최소 변환 횟수를 구해야 하므로 cnt를 각각의 단계에 맞게 저장하도록 대상 노드와 함께 그 시점의 cnt에서 + 1한 값을 동시에 큐에 append한다.

선입 선출의 너비 우선 탐색이니까 동일선상(=같은 레벨)에 있는 cnt는 모두 같을 것이다. 

시작 노드와의 레벨의 차이가 작을 수록 최소 변환 횟수. ----> 즉, 큐에서 꺼낸 값과 target이랑 같은지 비교해서 같으면 그 시점의 cnt가 최소 변환 횟수임. 같지 않다면 target과 같아질 때 또는 큐 요소가 없을 때(= 대상 요소 다 방문)까지 bfs반복 수행



내 bfs 풀이)

``` python
import collections

def bfs(begin, target, words, cnt):
    visited = []
    deq = collections.deque([(begin, cnt)])
    n = len(target)
    while(deq):
        word, cnt = deq.popleft()
        visited.append(word)
        if word == target:
            return cnt

        for i in range(len(words)):
            change = 0
            comp_word = words[i]
            for i in range(n):
                if word[i] != comp_word[i]:
                    change+=1
            if change == 1 and comp_word not in visited: 
                deq.append((comp_word, cnt + 1))
                cnt+=1

                visited.append(comp_word)

    return 0


def solution(begin, target, words):
    answer = bfs(begin, target, words, 0)
    if answer == 0:
        return 0
    else:
        return answer
```



다른 사람 bfs 풀이)

```python
from collections import deque

def can_change(cur_word, words):
    cand = []
    for word in words:
        diff = [True for x, y in zip(cur_word, word) if x != y]
        if len(diff) == 1: 
            cand.append(word)
    return cand

def solution(begin, target, words):
    visited = set([begin])
    que = deque([(begin, 0)])
    while que:
        cur_word, cur_count = que.popleft()
        # 확인
        if cur_word == target:
            return cur_count
        # 탐색
        for word in can_change(cur_word, words):
            if word not in visited:
                que.append((word, cur_count + 1))
                visited.add(word)
    return 0
```

 



