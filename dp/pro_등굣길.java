package dp;

public class pro_등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        if (map[1][2] == 0) {
            map[1][2] = 1;
        }
        if (map[2][1] == 0) {
            map[2][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != -1) {
                    //왼쪽이 물웅덩이가 아니라면 왼쪽꺼 더하기
                    if (map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1] % 1_000_000_007;
                    }
                    //위쪽이 물웅덩이가 아니라면 위쪽거 더하기
                    if (map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j] % 1_000_000_007;
                    }
                }
            }
        }

        return map[n][m] % 1_000_000_007;
    }

}
