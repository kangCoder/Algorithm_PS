package simulation;

import java.io.*;
import java.util.*;

public class boj_27495_만다라트만들기 {

    static String[][] matrix = new String[9][9];
    static PriorityQueue<SubGoal> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = st.nextToken();
            }
        }

        for (int i = 1; i < 8; i += 3) {
            for (int j = 1; j < 8; j += 3) {
                if (i == 4 && j == 4) {
                    continue;
                }

                PriorityQueue<String> ppq = new PriorityQueue<>();
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r == i && c == j) {
                            continue;
                        }
                        ppq.offer(matrix[r][c]);
                    }
                }
                pq.offer(new SubGoal(matrix[i][j], ppq, i, j));
            }
        }

        int idx = 1;
        while (!pq.isEmpty()) {
            SubGoal sg = pq.poll();
            bw.write("#" + idx + ". " + sg.goal + "\n");

            PriorityQueue<String> ppq = sg.subSubGoal;
            int idx1 = 1;
            while (!ppq.isEmpty()) {
                bw.write("#" + idx + "-" + (idx1++) + ". " + ppq.poll() + "\n");
            }

            idx++;
        }

        bw.flush();
    }

    static class SubGoal implements Comparable<SubGoal> {

        String goal;
        PriorityQueue<String> subSubGoal;
        int r, c;

        public SubGoal(String goal, PriorityQueue<String> subSubGoal, int r, int c) {
            this.goal = goal;
            this.subSubGoal = subSubGoal;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(SubGoal o) {
            return this.goal.compareTo(o.goal);
        }
    }
}
