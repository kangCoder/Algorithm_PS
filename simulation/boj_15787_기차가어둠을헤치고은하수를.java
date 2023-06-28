package simulation;

import java.util.*;
import java.io.*;

public class boj_15787_기차가어둠을헤치고은하수를 {

    static int N, M;
    static String[] command;
    static boolean[][] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        command = new String[M];
        for (int i = 0; i < M; i++) {
            command[i] = br.readLine();
        }
        //1 i x : i번째 기차의 x좌석에 탑승
        //2 i x : i번째 기차의 x좌석 손님 하차
        //3 i : i번째 기차 뒤로 한 칸씩
        //4 i : i번째 기차 앞으로 한 칸씩

        trains = new boolean[N + 1][21];
        for (int m = 0; m < M; m++) {
            String[] c = command[m].split(" ");
            switch (c[0]) {
                case "1": {
                    int i = Integer.parseInt(c[1]);
                    int x = Integer.parseInt(c[2]);

                    trains[i][x] = true; //승차 처리
                    break;
                }
                case "2": {
                    int i = Integer.parseInt(c[1]);
                    int x = Integer.parseInt(c[2]);

                    trains[i][x] = false; //하차 처리
                    break;
                }
                case "3": {
                    int i = Integer.parseInt(c[1]);

                    for (int j = 20; j >= 2; j--) {
                        trains[i][j] = trains[i][j - 1]; //한 칸씩 뒤로
                    }
                    trains[i][1] = false;
                    break;
                }
                case "4": {
                    int i = Integer.parseInt(c[1]);

                    for (int j = 1; j < 20; j++) {
                        trains[i][j] = trains[i][j + 1]; //한 칸씩 앞으로
                    }
                    trains[i][20] = false;
                    break;
                }
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            StringBuilder tmp = new StringBuilder();

            for (int j = 1; j <= 20; j++) {
                if (trains[i][j]) {
                    tmp.append("1");
                } else {
                    tmp.append("0");
                }
            }

            set.add(tmp.toString());
        }

        System.out.println(set.size());
    }
}