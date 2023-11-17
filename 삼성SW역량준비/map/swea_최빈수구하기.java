package 삼성SW역량준비.map;

import java.io.*;
import java.util.*;

public class swea_최빈수구하기 {

    static Map<Integer, Integer> studentScoreMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            studentScoreMap = new HashMap<>();
            int test = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                studentScoreMap.put(score, studentScoreMap.getOrDefault(score, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> scoreListDescend = new LinkedList<>(
                studentScoreMap.entrySet());
            scoreListDescend.sort(Map.Entry.comparingByValue());
            int maxScore = scoreListDescend.get(scoreListDescend.size() - 1).getKey();

            bw.write("#" + test + " " + maxScore + "\n");
        }

        bw.flush();
    }
}