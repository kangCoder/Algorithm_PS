package map;

import java.util.*;
import java.io.*;

public class boj_9375_패션왕신해빈 {

    static int n, ans = 1;
    static Map<String, Integer> wearMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 1;
            wearMap = new HashMap<>();

            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] wear = br.readLine().split(" ");
                wearMap.put(wear[1], wearMap.getOrDefault(wear[1], 0) + 1);
            }

            for (String category : wearMap.keySet()) {
                ans *= (wearMap.get(category) + 1);
            }

            System.out.println(ans - 1);
        }
    }
}
