package hash;

/*
    전화번호 목록 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
    전화번호부에 적힌 번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 체크

    input:
        - phone_booke : ["119", "97674223", "1195524421"]
    output:
        - return : false (접두어 있음)

    input:
        - phone_booke : ["123","456","789"]
    output:
        - return : true (접두어 없음)
 */

import java.util.Arrays;

public class No_42577 {

    private static final String[] PHONE_BOOK = {"119", "97674223", "1195524421"};

    public void solution() {
        boolean answer = false;

        // 정렬
        Arrays.sort(PHONE_BOOK);

        answer = checkPrefix(PHONE_BOOK);

        System.out.println("answer: " + answer);

    }

    private boolean checkPrefix(String[] sortedPhoneBook) {
        // 반복문 돌면서 접두어 체크
        for (int i = 0; i < sortedPhoneBook.length - 1; i++) {
            if (sortedPhoneBook[i + 1].startsWith(sortedPhoneBook[i])) {
                return false;
            }
        }

        return true;
    }

}
