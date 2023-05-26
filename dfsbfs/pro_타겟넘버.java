package dfsbfs;

public class pro_타겟넘버 {

    private int dfs(int[] numbers, int target, int cur, int sum) {
        int total = 0;

        if (cur == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        total += dfs(numbers, target, cur + 1, sum + numbers[cur]);
        total += dfs(numbers, target, cur + 1, sum + (numbers[cur] * -1));

        return total;
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

}
