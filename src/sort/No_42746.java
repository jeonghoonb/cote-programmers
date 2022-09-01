package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    가장 큰 수 (https://school.programmers.co.kr/learn/courses/30/lessons/42746)

    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 만들자.

    input:
        - numbers : [6, 10, 2]

    output:
        - answer : "6210"
 */
public class No_42746 {

    private static final String ZERO = "0";

    // Arguments
    int[] numbers = {6, 10, 2};
    StringBuilder stringBuilder = new StringBuilder();

    public void solution() {

        List<String> convertedAndSortedNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        if (ZERO.equals(convertedAndSortedNumbers.get(0))) {
            System.out.println(ZERO);
        } else {
            for (String convertedAndSortedNumber : convertedAndSortedNumbers) {
                stringBuilder.append(convertedAndSortedNumber);
            }
        }

        System.out.println(stringBuilder.toString());

    }

}
