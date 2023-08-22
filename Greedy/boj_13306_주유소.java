package greedy;

import java.util.*;
import java.io.*;

public class boj_13306_주유소 {

    static int N, min = Integer.MAX_VALUE;
    static long sum = 0L;
    static int[] city;
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        city = new int[N];
        road = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            min = Math.min(min, city[i - 1]);
            sum += (long) road[i - 1] * min;
        }

        System.out.println(sum);
    }

}
