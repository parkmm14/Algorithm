import java.util.*;
/*
* n편 중, h 번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용
* 즉, h번 이상 인용된 논문 개수가 h편 이상 h의 최댓값 구하기.
* 정렬한 후 앞에서부터 가면서 처음 h-index가 성립한 순간을 고르면 된다.
* 인덱스가 증가할수록 인용된 논문 수는 줄어드니까 끝까지 해볼 필요 x.
* */

class Solution {
    public int solution(int[] citations) {
        int ans = 0, h_idx = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int k = citations.length - i;
            h_idx = citations[i];

            if(k <= h_idx) {
                ans = k;
                return ans;
            }
        }
        return ans;
    }
}