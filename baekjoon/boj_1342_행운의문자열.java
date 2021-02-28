import java.util.*;
import java.io.*;
//조건을 만족할 때의 모든 순열 조합 경우의 수 => dfs 백트래킹 + 팩토리얼 (중복제거)
public class Main{
    static String s;
    static char[] s_charArr;
    static boolean[] visited;
    static int size;

     public static void main(String []args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        s_charArr = s.toCharArray();

        // 문자 하나씩 선택(시작)
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            visited = new boolean[s.length()];

            sb.append(s_charArr[i]);
            visited[i] = true;
            backtracking(sb, s.length());

        }

        char[] alphbet = new char[26];

        //중복 요소 카운팅
        for(int i = 0; i < s.length(); i++) {
            alphbet[s_charArr[i]-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(alphbet[i] > 1) {
                size /= factorial(alphbet[i]);
            }
        }

        System.out.println(size);
}

    public static void backtracking(StringBuilder sb, int n) {

        if(sb.length() == n) {  // 모든 문자를 뽑았을 경우
            size++;
            return;
        }

        for(int i = 0; i < n; i++) { // 모든 문자 탐색
            if(!visited[i]) {   // 아직 선택하지 않은 문자면

                if(sb.charAt(sb.length()-1) != s_charArr[i]) {
                    //선택하는 경우
                    visited[i] = true;
                    sb.append(s_charArr[i]);
                    backtracking(sb, n);
                    //선택하지 않은 경우 (=백트래킹)
                    //성공하기 직전의 단계로 되돌아가서(= back) 다음으로 가능한 답을 찾는다.
                    sb.deleteCharAt(sb.length()-1);
                    visited[i] = false;
                }
            }
        }
    }
    public static int factorial(int n) {
        if(n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}