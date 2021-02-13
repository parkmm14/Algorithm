import java.util.*;
/*
배열을 이용하는 hashMap 자료 구조 이용.
uid와 name을 Key-value 항상 최신화.

닉네임이 바뀌면 이전에 기록된 로그의 닉임도 바꿔야한다.
닉네임은 hashMap에 기록하고 ArrayList에 유저id기반의 로그를 기록한다.
ArrayList를 String 배열에 담으면서 유저ID를 닉네임으로 바꾼다.
*/
public class openChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> info = new HashMap<>();
        ArrayList<String> chatLog = new ArrayList<>();
        String[] answer = {};

        for(String str : record) {
            String[] input = str.split(" ");
            String cmd = input[0];
            String uid = input[1];
            String nickName = "";
            if(!cmd.equals("Leave"))
                nickName = input[2];
            switch(cmd){
                case "Enter":
                    info.put(uid, nickName);
                    chatLog.add(uid+"님이 들어왔습니다.");
                    break;
                    // 정보 상태 변화 없다.
                case "Leave":
                    chatLog.add(uid+"님이 나갔습니다.");
                    break;
                    //uid nickname 값 업데이트 --> key value 최신화의
                case "Change":
                    info.put(uid, input[2]);
                    break;

            }
        }

        int size = chatLog.size();
        answer = new String[size];
        for(int i = 0; i < size; i++) {
            String str = chatLog.get(i);
            //indexOf로 해당값의 시작 인덱스 반환
            int endIdx = str.indexOf("님");
            // 시작 인덱스~ 끝 인덱스 직전 인덱스까지 자른 문자열 생성
            String userId = str.substring(0, endIdx);
            //userId의 nickName 최신 값으로 대치해서 배열에 저장.
            answer[i] = str.replace(userId, info.get(userId));
        }

        return answer;

    }
}
