package 삼성SW역량준비.dp.boj_3687_성냥개비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
     * 각 숫자를 만들 때 필요한 성냥개비의 수
     * 1: 2개, 2: 5개, 3: 5개, 4: 4개, 5: 5개, 6: 6개, 7: 3개, 8: 7개, 9: 6개, 0: 6개
     * 가장 많이 필요한 숫자: 8(7개)
     * 가장 적게 필요한 숫자: 1(2개)
     */

    /*
     * 가장 큰 숫자를 만드는 방법: 적게 필요한 숫자를 사용하여 자릿수를 길게 늘어놓는다.
     * 성냥개비가 짝수개일 때 가장 큰 수: 11111.....11
     * 홀수개일 때 가장 큰 수: 7111...11
     */

    /*
     * 가장 작은 숫자를 만드는 방법
     * 필요한 성냥개비가 겹치는 숫자 중 가장 작은 숫자를 써야 함. (2개: 1, 3개: 7, 4개: 4, 5개: 2, 6개: 0, 7개: 8)
     * 6개인 경우 예외가 존재: 0은 혼자서 쓰일 수 없음. -> 정답이 한 자리 숫자거나 첫 자리에 무조건 6개를 써야할 때 6을 쓰고, 그 외에는 0을 쓴다.
     * 2~7개의 개수로 만들 수 있는 최소 숫자 -> [1, 7, 4, 2, 0(6), 8]
     */

    public static int N;
    public static long[] minDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            //큰 숫자 구하기
            StringBuilder max = new StringBuilder();
            if (N % 2 == 0) {
                max.append("1");
            } else {
                max.append("7");
            }
            for (int j = 0; j < (N / 2) - 1; j++) {
                max.append("1");
            }

            //작은 숫자 구하기
            //[1, 7, 4, 2, 0(6), 8]
            minDP = new long[101];
            Arrays.fill(minDP, Long.MAX_VALUE);

            String[] min = {"1", "7", "4", "2", "0", "8"};
            minDP[2] = 1;
            minDP[3] = 7;
            minDP[4] = 4;
            minDP[5] = 2;
            minDP[6] = 6; //첫 자리가 아닐 때는 0이 와야함.
            minDP[7] = 8;

            minDP[8] = 10; //8개로 만들 수 있는 가장 작은 수는 10.
            for (int j = 9; j <= 100; j++) {
                //점화식
                //minDP[n] = Math.min(minDP[n-2]+minDP[2], minDP[n-3]+minDP[3], ... , minDP[n-7]+minDP[7])
                for (int k = 2; k <= 7; k++) {
                    String x = minDP[j - k] + min[k - 2]; //실제 더하는게 아니라 뒤에 붙이는 것임.
                    minDP[j] = Math.min(minDP[j], Long.parseLong(x));
                }
            }

            System.out.println(minDP[N] + " " + max);
        }
    }

}
