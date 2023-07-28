package sort;

import java.util.*;
import java.io.*;

public class boj_18869_멀티버스2 {

    static int M, N, ans = 0;
    static Map<Integer, Integer> rankingMap;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] universe = new int[N];
            int[] sorted = new int[N];
            for (int j = 0; j < N; j++) {
                sorted[j] = universe[j] = Integer.parseInt(st.nextToken());
            }

            //좌표압축
            rankingMap = new HashMap<>();
            Arrays.sort(sorted);
            int rank = 0;
            for (int v : sorted) {
                if (!rankingMap.containsKey(v)) {
                    rankingMap.put(v, rank++);
                }
            }
            //압축한 좌표를 한줄로 만들기
            StringBuilder sb = new StringBuilder();
            for (int univ : universe) {
                int ranking = rankingMap.get(univ);
                sb.append(ranking);
            }

            list.add(sb.toString());
        }

        Collections.sort(list);
        int cnt = 1;
        for (int i = 1; i < M; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                cnt++;
            } else {
                ans += cnt * (cnt - 1) / 2;
                cnt = 1;
            }
        }
        ans += cnt * (cnt - 1) / 2;

        System.out.println(ans);
    }

}