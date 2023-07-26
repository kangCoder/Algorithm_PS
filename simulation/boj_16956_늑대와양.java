package simulation;

import java.util.*;
import java.io.*;

public class boj_16956_늑대와양 {

    static int R, C, ans = 1;
    static char[][] ranch;
    static List<int[]> wolves = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void solve() {
        for (int[] wolf : wolves) {
            //양과 늑대과 인접해있으면 울타리 설치 불가.
            for (int dir = 0; dir < 4; dir++) {
                int nx = wolf[0] + dx[dir];
                int ny = wolf[1] + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }
                if (ranch[nx][ny] == 'S') {
                    ans = 0;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ranch = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                ranch[i][j] = str.charAt(j);
                if (ranch[i][j] == 'W') {
                    wolves.add(new int[] {i, j});
                }
            }
        }

        solve();
        if (ans == 1) {
            System.out.println(ans);
            //인접하지만 않으면 빈 칸에 울타리 싹 세우면 문제 없음.
            for (char[] chars : ranch) {
                for (char aChar : chars) {
                    if (aChar == '.') {
                        System.out.print('D');
                    } else {
                        System.out.print(aChar);
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println(ans);
        }
    }

}