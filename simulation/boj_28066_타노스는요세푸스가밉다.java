package simulation;

import java.io.*;
import java.util.*;

public class boj_28066_타노스는요세푸스가밉다 {

    static int N, K;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            if (list.size() > K) {
                for (int i = 2; i <= K; i++){
                    list.remove(1);
                }
                int first = list.remove(0);
                list.add(first);
            } else {
                int first = list.remove(0);
                list.clear();
                list.add(first);
            }
        }

        System.out.println(list.get(0));
    }

}
