package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_2636_치즈 {

    static int r, c, cheese;
    static int[][] plate;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int[] solve() {
        int lastCheese = 0;
        int time = 0;

        while (cheese > 0) {
            boolean[][] visited = new boolean[r][c];
            Queue<int[]> q = new LinkedList<>();
            List<int[]> edge = new ArrayList<>();

            visited[0][0] = true;
            q.offer(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = cur[0] + dr[dir];
                    int nc = cur[1] + dc[dir];

                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc]) {
                        if (plate[nr][nc] == 0) {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        } else {
                            visited[nr][nc] = true;
                            edge.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            for (int[] ints : edge) {
                plate[ints[0]][ints[1]] = 0;
            }

            if (edge.size() >= cheese) {
                lastCheese = cheese;
            }
            cheese -= edge.size();
            time++;
        }

        return new int[]{time, lastCheese};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        plate = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
                if (plate[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int[] ans = solve();
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}
