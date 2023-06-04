package greedy;

import java.util.*;
import java.io.*;

public class pro_2217_로프 {

    static int N, maxWeight = 0;
    static int[] ropes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        for (int i = 0; i < N; i++) {
            maxWeight = Math.max(maxWeight, ropes[i] * (N - i));
        }

        System.out.println(maxWeight);
    }
}
