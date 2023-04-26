package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16987_계란으로계란치기 {

    static int N, max = 0;
    static Egg[] eggs;

    public static void backTracking(int breakCnt, int start) {
        if (start == N) {
            max = Math.max(max, breakCnt);
            return;
        }

        //든게 깨졌는지, 다른게 다 깨졌는지 검사한다.
        if (eggs[start].durability <= 0 || breakCnt == N - 1) {
            backTracking(breakCnt, start + 1);
            return;
        }

        //가장 최근에 든 계란의 오른쪽 계란을 들고, 2번을 반복한다.
        for (int i = 0; i < N; i++) {
            if (start == i) {
                continue;
            }

            if (eggs[i].durability <= 0) {
                continue;
            }

            //계란을 쳐서 서로의 무게만큼 내구도가 감소한다.
            eggs[start].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[start].weight;

            //깨졌는지 검사.
            int tmp = breakCnt;
            if (eggs[start].durability <= 0) {
                breakCnt++;
            }
            if (eggs[i].durability <= 0) {
                breakCnt++;
            }

            backTracking(breakCnt, start + 1);

            //다시 원상복구
            eggs[start].durability += eggs[i].weight;
            eggs[i].durability += eggs[start].weight;
            breakCnt = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        backTracking(0, 0);
        System.out.println(max);
    }

    static class Egg {

        int durability, weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
