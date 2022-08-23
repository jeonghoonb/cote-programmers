package stackAndQueue;

import java.util.*;

/*
    기능 개발 (https://school.programmers.co.kr/learn/courses/30/lessons/42586)

    각 기능의 진도가 100일 때 배포가 가능하다.
    작업 진도(progressess)와 작업 속도(speeds)가 주어질 때 각 배포마다 몇개의 기능이 배포되는지 계산하기

    input:
        - progressess : [93, 30, 50]
        - speeds : [1, 30, 5]
    output:
        - answer : [2, 1]
 */
public class No_42586 {

    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    static final double MAX_PROGRESS = 100;

    public void solution() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double remainProgress = MAX_PROGRESS - progresses[i];
            int remainDay = (int) Math.ceil(remainProgress / speeds[i]);
            queue.add(remainDay);
        }

        List<Integer> answers = new ArrayList<>();
        int day = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            if (day < queue.peek()) {
                answers.add(count);
                count = 1;
                day = queue.poll();
            } else {
                count++;
                queue.poll();
            }
        }
        answers.add(count);

        int[] answer = answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.stream(answer)
                .forEach(System.out::println);

    }
}
