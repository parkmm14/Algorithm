프로그래머스 완전탐색 lv2  카펫



나의 풀이 : 약수로 x, y후보를 먼저 구한 다음, 둘레를 이용하여 판별

``` python
def solution(brown, yellow):
    answer = []
		//약수를 구하기 위해 전체 합 계산 
    total = brown + yellow
	
    x = total
    y = 1
    //x>=y 조건에 의해 for문 range 값 범위로 k 계산
    k = int(total**0.5)
   	
    for i in range(1, k+1):
        if total%i==0:
            y = i
            x = total//i
            if ((x*2)+(y*2)-4) == brown:
                answer = [x,y]
                return answer
```



다른 사람의 풀이 

``` python
def solution(brown, red):
    for i in range(1, int(red**(1/2))+1):
        if red % i == 0:
            if 2*(i + red//i) == brown-4:
                return [red//i+2, i+2]
```

