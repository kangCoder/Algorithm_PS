package greedy;

import java.util.*;
import java.io.*;

public class boj_15903_카드합체놀이 {

    static int n, m;
    static long ans = 0L;
    static PriorityQueue<Long> card = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            card.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = card.poll();
            long y = card.poll();
            card.offer(x + y);
            card.offer(x + y);
        }

        while (!card.isEmpty()) {
            ans += card.poll();
        }

        System.out.println(ans);
    }
}
