package sort;

/*
    K 번째 수 (https://school.programmers.co.kr/learn/courses/30/lessons/42748)
    주어진 배열을 i번째 숫자부터 j번째 숫자까지 자르고 정렬, 그 이후 k번째 수 구하기

    input:
        - array : [1, 5, 2, 6, 3, 7, 4]
        - commands : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    output:
        - return : [5, 6, 3]
 */

import java.util.*;

public class No_42748 {

    private static final int[] ARRAY = {1, 5, 2, 6, 3, 7, 4};
    private static final int[][] COMMANDS = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};


    public void solution() {
        int[] answers = new int[COMMANDS.length];

        for (int index = 0; index < COMMANDS.length; index++) {
            int i = COMMANDS[index][0];
            int j = COMMANDS[index][1];
            int k = COMMANDS[index][2];

            // 배열 자르기
            int[] splitArray = Arrays.copyOfRange(ARRAY, i - 1, j);

            // 정렬
            Arrays.sort(splitArray);

            answers[index] = splitArray[k - 1];
        }

        Arrays.stream(answers)
                .forEach(System.out::println);

    }

}
