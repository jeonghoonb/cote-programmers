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

    int[] nums = {1, 2, 3, 4};
    int answer = 0;

    public void solution() {

        // 주어진 nums에서 3개의 수 더하고 소수 개수 체크하기
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private boolean isPrime(int num) {
        System.out.println("num: " + num + ", sqrt: " + Math.sqrt(num));
        if (1 == num) return false;
        if (2 == num) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

}
