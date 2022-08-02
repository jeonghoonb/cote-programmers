package lv1;

/*
    소수 만들기 (https://school.programmers.co.kr/learn/courses/30/lessons/12977)
    주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수 구하기
    input:
        - nums = [1, 2, 3, 4]
    output:
        - 1
 */
public class No_12977 {
    public void solution() {
        // input
        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1, 2, 7, 6, 4};
        int answer = -1;

        // local 변수
        int totalSum = 0;

        // 전부 더하기
        for (int num : nums) {
            totalSum += num;
        }

        // 항목

        // ansert
        System.out.println(answer);
    }

}
