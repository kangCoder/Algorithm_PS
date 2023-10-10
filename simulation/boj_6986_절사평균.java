package simulation;

import java.util.*;
import java.io.*;

public class boj_6986_절사평균 {

    static int N, K; //점수의 개수, 양 끝에서 제외할 점수의 개수
    static double jul = 0, bo = 0;
    static double[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(score);

        //절사평균 구하기
        //양 끝에서 K개를 제외한 나머지의 평균
        for (int i = K; i < N - K; i++) {
            jul += score[i];
        }
        jul = jul / (N - 2 * K);

        //보정평균 구하기
        //양 끝 K개를 남은 정수 중 각각 가까운 수로 교체
        for (int i = 0; i < K; i++) {
            score[i] = score[K];
        }
        for (int i = N - 1; i >= N - K; i--) {
            score[i] = score[N - K - 1];
        }
        for (Double d : score) {
            bo += d;
        }
        bo = bo / N;

        System.out.printf("%.2f%n", jul);
        System.out.printf("%.2f%n", bo);
    }

}
