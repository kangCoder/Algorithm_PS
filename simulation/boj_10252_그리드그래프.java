package simulation;

import java.util.*;
import java.io.*;

public class boj_10252_그리드그래프 {

    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            //불가능한 경우가 없는 것 같은데...
            System.out.println(1);

            //행이 짝수인 경우와 아닌 경우로 나뉨
            if (m % 2 == 0) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        //짝수 행을 지날 때는 뒤에서부터 훑기
                        if (i % 2 == 0) {
                            System.out.println("(" + i + "," + (n - 1 - j) + ")");
                        } else {
                            //홀수 행을 지날 때는 앞에서 부터 훑기
                            System.out.println("(" + i + "," + j + ")");
                        }
                    }
                }
            } else {
                //행이 홀수 개일 때는 일단 마지막 열은 뺴고 일단 짝수 개인 것처럼 돌린다
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (i % 2 == 0) {
                            System.out.println("(" + i + "," + (n - 2 - j) + ")");
                        } else {
                            System.out.println("(" + i + "," + j + ")");
                        }
                    }
                }

                //그리고 마지막 열에 대해서 돌리기
                System.out.println("(" + (m - 1) + "," + (n - 1) + ")");
                for (int i = m - 2; i >= 0; i--) {
                    System.out.println("(" + i + "," + (n - 1) + ")");
                }
            }
        }
    }
}