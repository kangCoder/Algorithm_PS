package 자료구조.heap;

import java.util.*;
import java.io.*;

public class boj_7662_이중우선순위큐 {

    static int k;
    static TreeMap<Long, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            map = new TreeMap<>();

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] op = br.readLine().split(" ");
                if (op[0].equals("I")) {
                    long insert = Long.parseLong(op[1]);
                    map.put(insert, map.getOrDefault(insert, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    long delete = Long.parseLong(op[1]) == 1 ? map.lastKey() : map.firstKey();
                    int cnt = map.get(delete);
                    if (cnt == 1) {
                        map.remove(delete);
                    } else {
                        map.put(delete, cnt - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
