package dp;

public class pro_정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        int len = triangle.length;

        int[][] dp = new int[len][len]; //dp[i][j]: i-1번째 layer의 j-1번째 위치에 있을 때 거쳐간 합의 최댓값
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

        for (int i = 2; i < len; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //양 끝 처리
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, dp[len - 1][i]);
        }

        return answer;
    }
}
