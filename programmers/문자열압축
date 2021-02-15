import java.util.*;


class Solution {
    public int solution(String s) {

        int min = s.length();
        // 단위 초기화 주의 (0으로 주면 무한루프 빠져서 시간초과)
        for(int i = 1; i <= s.length() / 2; i++) {

            int compLen = compression(s, i).length();
            min = Math.min(min, compLen);

        }

        return min;
    }

    public String compression(String str, int i) {

        String pattern="";      //이전 문자열 저장할 문자열
        int cnt = 1;            //압축 계산 디폴트는 1
        String compression=""; //문자열 압축 과정 저장할 문자열

        for(int j = 0; j <= str.length()+i; j+=i) { //이전문자열을 저장하는 구조이므로 현재 문자열이 이전 문자열로 처리되도록 현재 문자열이 없는 경우까지 포함해야 하기 때문에 +i
            String nowStr;
            if (j >= str.length()) { // 현재 문자열이 없는 경우
                nowStr = "";
            } else if (str.length() < j + i) { // 마지막 문자열이면서 압축 단위보다 크기가 작은 경우
                nowStr = str.substring(j);
            } else {
                nowStr = str.substring(j, j + i); // 그외 모든 경우
            }

            if(j!=0) {
                if(nowStr.equals(pattern)){
                    cnt++;
                }
                else if(cnt>=2){
                    compression += cnt + pattern;
                    cnt = 1;
                }
                else{
                    compression += pattern;
                }
            }

            pattern = nowStr;
        }
        return compression;

    }
}