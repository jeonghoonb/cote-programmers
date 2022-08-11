package lv1;

import java.util.*;
import java.util.stream.Collectors;

/*
    신고 결과 받기 (https://school.programmers.co.kr/learn/courses/30/lessons/92334)
    input:
        - id_list: ["muzil", "frodo", "apeach", "neo"]
        - report: ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
        - k: 2
    output:
        - result: [2, 1, 1, 0]

 */
public class No_92334 {

    private final static String DELIMETER = " ";
    private final static int ZERO = 0;
    private final static int ONE = 1;

    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k = 2;

    public void solution() {
        int answer[] = new int[id_list.length];

        // reports 중복 제거
        HashSet<String> reportHashSet = new HashSet<>();
//        for (String rep : report) {
//            reportHashSet.add(rep);
//        }

        reportHashSet.addAll(Arrays.stream(report).collect(Collectors.toList()));

        // HashMap<String, ArrayList<String>> 으로 신고 당한 사람, 신고 한 사람들 체크
        HashMap<String, ArrayList<String>> suspendedUser = new HashMap<>();
        for (String rep : reportHashSet) {
            String reporter = rep.split(DELIMETER)[ZERO];
            String reportee = rep.split(DELIMETER)[ONE];

            ArrayList<String> reporters = suspendedUser.getOrDefault(reportee, new ArrayList<>());
            reporters.add(reporter);

            suspendedUser.put(reportee, reporters);
        }

        // ArrayList<String> 이 K 이상인 경우 해당 유저를 신고한 사람들 체크
        HashMap<String, Integer> notifyUser = new HashMap<>();
        for (ArrayList<String> reporters : suspendedUser.values()) {
            if (reporters.size() >= k) {
                for (String rep : reporters) {
                    notifyUser.put(rep, notifyUser.getOrDefault(rep, 0) + 1);
                }
            }
        }

        // 결과 메일 answer
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = notifyUser.getOrDefault(id_list[i], 0);
        }

        for (int i : answer) {
            System.out.println(i);
        }

    }
}
