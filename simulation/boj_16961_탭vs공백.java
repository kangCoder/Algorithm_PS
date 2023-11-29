package simulation;

import java.io.*;
import java.util.*;

public class boj_16961_탭vs공백 {

    static int N;
    static int one = 0, many = 0, notFight = 0, notFightMax = 0, max = 0;
    static int[] dayT, dayS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        dayT = new int[367];
        dayS = new int[367];
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (type.equals("S")) {
                for (int j = start; j <= end; j++) {
                    dayS[j]++;
                }
            } else if (type.equals("T")) {
                for (int j = start; j <= end; j++) {
                    dayT[j]++;
                }
            }
            max = Math.max(max, end - start + 1);
        }



        //싸움이 없는 날 == S와 T의 수가 동일한 날
        for (int i = 1; i <= 366; i++) {
            //투숙객이 1명 이상인 날의 수
            if (dayT[i] > 0 || dayS[i] > 0) {
                one++;
            }

            //가장 많은 투숙객이 있던 날에 투숙한 사람의 수
            many = Math.max(many, dayS[i] + dayT[i]);

            if (dayT[i] > 0 && dayT[i] == dayS[i]) {
                notFight++;
                //싸움이 없는 날 중 가장 많은 투숙객이 있던 날의 사람 수 (없으면 0)
                notFightMax = Math.max(notFightMax, dayT[i] + dayS[i]);
            }
        }
        bw.write(one + "\n");
        bw.write(many + "\n");
        bw.write(notFight + "\n");
        bw.write(notFightMax + "\n");

        //가장 오랜 기간 투숙한 사람이 투숙한 날의 수
        bw.write(max + "\n");

        bw.flush();
    }
}
