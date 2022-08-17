package hash;

import java.util.HashSet;

/*
    포켓몬 (https://school.programmers.co.kr/learn/courses/30/lessons/1845)
    N 마리의 포켓몬 중 N/2를 고를 때, 선택할 수 있는 포켓몬 종류의 최대값 구하기 (중복 x)
    input:
        - nums = [3, 1, 2, 3]
    output:
        - 2
 */
public class No_1845 {

    int[] nums = {3, 3, 3, 2, 2, 2};
    int answer = 0;

    public void solution() {

        // Set에 넣어 중복 제거
        HashSet<Integer> pocketmonSet = new HashSet<>();
        for (int num : nums) {
            pocketmonSet.add(num);
        }

        // 이후 Set size와 nums/2의 사이즈 중 작거나 같은 값 고르기
        answer = Integer.min(nums.length / 2, pocketmonSet.size());

        /* Stream 이용 하기
        answer = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        pocketmon -> Integer.min(pocketmon.size(), nums.length / 2)));
         */

        System.out.println("answer: " + answer);
    }
}
