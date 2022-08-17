package hash;

import java.util.*;

/*
    완주하지 못한 선수 (https://school.programmers.co.kr/learn/courses/30/lessons/42576)
    마라톤 참가자 중 완주하지 못 한 사람 찾기

    input :
        - participant: ["mislav", "stanko", "mislav", "ana"]
        - completion: ["stanko", "ana", "mislav"]
    output:
        - "mislav"
 */
public class No_42576 {

    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};

    public void solution () {
        String answer = "";

        HashMap<String, Integer> participantMap = new HashMap<>();
        for (String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }

        for (Map.Entry<String, Integer> entry : participantMap.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        System.out.println(answer);
    }
}
