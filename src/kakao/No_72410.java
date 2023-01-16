package kakao;

/*
    신규 아이디 추천 (https://school.programmers.co.kr/learn/courses/30/lessons/72410)

    아이디를 입력 받고, 조건에 맞게 필터링 후 아이디를 추천해주기.

    input:
        - new_id : "...!@BaT#*..y.abcdefghijklm"

    output:
        - result : "bat.y.abcdefghi"

 */
public class No_72410 {

    private static final String NEW_ID = "...!@BaT#*..y.abcdefghijklm";

    public void solution() {

        String answer = "";

        if (1 > NEW_ID.length() || 1000 < NEW_ID.length() ) {
            throw new IllegalArgumentException("ID는 3자 이상, 15자 이하여야 합니다.");
        }

        // 대문자 -> 소문자 치환
        answer = toLowerCase();

        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 외 문자 제거
        answer = filter(answer);

        // 마침표 연속된 부분 1개로 치환
        answer = replaceToSingleDot(answer, "[.]{2,}", ".");

        // 처음과 끝에 위치한 마침표 제거
        answer = deleteToFirstAndLastDot(answer);

        // 빈 문자열인 경우 "a" 대입
        answer = blankToA(answer);

        // 16자 이상이라면 15자로 추출
        answer = filterByLengthOver15(answer);

        // 끝 마침표 제거
        answer = deleteToFirstAndLastDot(answer);

        // 2자 이하라면 마지막 문자 반복시켜서 3자 만들기
        answer = filterByLengthUnder2(answer);

        System.out.println(answer);
    }

    private String toLowerCase() {
        return NEW_ID.toLowerCase();
    }

    private String filter(String answer) {
        return answer.replaceAll("[^-_.\\w]", "");
    }

    private String replaceToSingleDot(String answer, String regex, String replacement) {
        return answer.replaceAll(regex, replacement);
    }

    private String deleteToFirstAndLastDot(String answer) {
        return answer.replaceAll("^[.]|[.]$", "");
    }

    private String blankToA(String answer) {
        if (answer.isBlank()) {
            answer = "a";
        }

        return answer;
    }

    private String filterByLengthOver15(String answer) {
        if (15 < answer.length()) {
            answer = answer.substring(0, 15);
        }

        return answer;
    }
    private String filterByLengthUnder2(String answer) {
        while (3 > answer.length()) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

}
