package simulation;

import java.util.*;
import java.io.*;

public class boj_16960_스위치와램프 {

    static int N, M;
    static int[] lamps;
    static Map<Integer, List<Integer>> switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lamps = new int[M + 1];
        switches = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int lampNum = Integer.parseInt(st.nextToken());

            for (int j = 0; j < lampNum; j++) {
                int n = Integer.parseInt(st.nextToken());
                lamps[n]++;
                list.add(n);
            }

            switches.put(i + 1, list);
        }

        boolean flag = false;
        for (Integer s : switches.keySet()) {
            List<Integer> list = switches.get(s);
            int[] tmp = lamps.clone();

            for (Integer l : list) {
                lamps[l]--;
            }

            int cnt = 0;
            for (int i = 1; i <= M; i++) {
                if (lamps[i] <= 0) {
                    break;
                } else {
                    cnt++;
                }
            }

            if (cnt == M) {
                flag = true;
                break;
            }

            lamps = tmp;
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
