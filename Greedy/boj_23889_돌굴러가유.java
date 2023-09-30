package greedy;

import java.util.*;
import java.io.*;

public class boj_23889_돌굴러가유 {

    static int N, M, K;
    static int[] town, stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        town = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }
        stone = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        //각 돌의 위치부터 다음 돌의 위치까지 굴렀을 때 파괴될 모래성의 수를 센다.
        List<Destroy> destroy = new ArrayList<>();
        for (int i = 0; i < K - 1; i++) {
            int sum = 0;
            int start = stone[i] - 1;
            int end = stone[i + 1] - 1;

            for (int j = start; j < end; j++) {
                sum += town[j];
            }

            destroy.add(new Destroy(stone[i], sum));
        }
        int lastStone = stone[K - 1];
        int lastSum = 0;
        for (int i = lastStone - 1; i < N; i++) {
            lastSum += town[i];
        }
        destroy.add(new Destroy(lastStone, lastSum));

        //파괴된 모래성을 기준으로 내림차순 정렬.
        //만약 같다면 위치 사전순 오름차순 정렬.
        destroy.sort((x, y) -> {
            int result = Integer.compare(y.cnt, x.cnt);
            if (result == 0) {
                return Integer.compare(x.pos, y.pos);
            }
            return result;
        });

        //가장 많이 파괴되는 곳부터 벽을 세운다.
        destroy = destroy.subList(0, M);
        List<Integer> ans = new ArrayList<>();
        for (Destroy d : destroy) {
            ans.add(d.pos);
        }

        Collections.sort(ans);
        for (Integer i : ans) {
            System.out.println(i);
        }
    }

    static class Destroy {

        int pos, cnt;

        public Destroy(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
