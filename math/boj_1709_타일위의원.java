package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1709_타일위의원 {

    static long N, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        N /= 2;
        long x = 0, y = N - 1; //타일의 왼쪽 아래 꼭지점부터 시작
        while (x <= N && y >= 0) {
            long diff = (x + 1) * (x + 1) + y * y; //원점에서 (x+1, y)까지의 거리

            //거리가 반지름보다 작다 -> 타일의 왼쪽 아래 꼭지점이 원 안에 있음 -> x증가
            if (diff <= N * N) {
                x++;
            }
            //거리가 반지름보다 크다 -> 타일의 왼쪽 아래 꼭지점이 원 밖에 있음 -> y감소
            if (diff >= N * N) {
                y--;
            }

            ans++;
        }

        System.out.println(ans * 4);
    }
}