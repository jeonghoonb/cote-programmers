package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
    같은 숫자는 싫어 (https://school.programmers.co.kr/learn/courses/30/lessons/12906)
    주어지는배열에서 연속되는 숫자를 1개만 남기고 다 제거한 결과 받기
    배열 순서 유지 필요

    input:
        - arr = [1,1,3,3,0,1,1]
    output:
        - answer = [1,3,0,1]
 */
public class No_12906 {

    int[] arr = {1, 1, 3, 3, 0, 1, 1};

    public void solution() {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int no : arr) {
            if (arrayDeque.isEmpty()) {
                arrayDeque.add(no);
                continue;
            }

            if (arrayDeque.peekLast() != no) {
                arrayDeque.add(no);
            }

        }

        int[] answer = new int[arrayDeque.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayDeque.pollFirst();
        }


        Arrays.stream(answer)
                .forEach(System.out::println);

    }
}

