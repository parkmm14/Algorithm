import java.util.*;
//배열을 이용하는 hashMap 자료 구조 이용.
//uid와 name을 Key-value 항상 최신화.
//닉네임은 hashMap에 기록하고 ArrayList에 유저id기반의 로그를 기록한다.

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

                case "Leave":
                    chatLog.add(uid+"님이 나갔습니다.");
                    break;
                case "Change":
                    info.put(uid, input[2]);
                    break;

            }
        }

        int size = chatLog.size();
        answer = new String[size];
        for(int i = 0; i < size; i++) {
            String str = chatLog.get(i);
            int endIdx = str.indexOf("님");
            String userId = str.substring(0, endIdx);

            answer[i] = str.replace(userId, info.get(userId));
        }

        return answer;

    }
}
