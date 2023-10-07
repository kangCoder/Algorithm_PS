package 자료구조.hash;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class boj_13414_수강신청 {

    static int K, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int idx = 1;
        for (int i = 0; i < L; i++) {
            String stuNum = br.readLine();
            map.put(stuNum, idx++);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        if (entries.size() <= K) {
            for (Entry<String, Integer> entry : entries) {
                System.out.println(entry.getKey());
            }
        } else {
            for (int i = 0; i < K; i++) {
                System.out.println(entries.get(i).getKey());
            }
        }
    }
}
