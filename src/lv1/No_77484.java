package lv1;

import java.util.Scanner;

/*
    로또의 최고 순위와 최저 순위 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/77484)
    input:
        - lottos = [44, 1, 0, 0, 31, 25]
        - win_nums = [31, 10, 25, 1, 6, 19]
    output:
        - [3, 5]
 */
public class No_77484 {

    public void solution() {
        // input
        int[] answer = {};
        int[] lottos = new int[6];
        int[] win_nums = new int[6];

        // local 변수
        int correct = 0;
        int zeroCnt = 0;

        // scanner
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            lottos[i] = scanner.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            win_nums[i] = scanner.nextInt();
        }

        // 0 개수, 맞춘 숫자 개수 구하기
        for (int win_num : win_nums) {
            for (int lotto : lottos) {
                if (0 == lotto) {
                    zeroCnt++;
                }
                if (win_num == lotto) {
                    correct++;
                }
            }
        }

        answer = new int[2];
        answer[0] = ranking(zeroCnt / 6 + correct);
        answer[1] = ranking(correct);

        System.out.println(answer[0] + ", " + answer[1]);

    }

    public int ranking(int correct) {
        return switch (correct) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
