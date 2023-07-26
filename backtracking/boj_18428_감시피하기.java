package backtracking;

import java.util.*;
import java.io.*;

public class boj_18428_감시피하기 {

    static int N, obstacle = 3;
    static String ans = "YES";
    static char[][] corridor;
    static List<int[]> teacherPos = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void backTracking(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            //바로 옆이 학생이면 감시를 피할 수 없다.
            if (corridor[nx][ny] == 'S') {
                obstacle--;
                ans = "NO";
                return;
            } else if (corridor[nx][ny] == 'O' || corridor[nx][ny] == 'T') {
                continue;
            }

            //상하좌우로 부딪힐 때까지 쭉 가면서 판단
            for (int i = 0; i < N; i++) {
                int nnx = nx + i * dx[dir];
                int nny = ny + i * dy[dir];

                if (nnx < 0 || nnx >= N || nny < 0 || nny >= N) {
                    continue;
                }

                //가다가 장애물이나 선생이면 멈추고, 학생이면 쭉 가는 길에 설치
                if (corridor[nnx][nny] == 'O' || corridor[nnx][nny] == 'T') {
                    break;
                } else if (corridor[nnx][nny] == 'S') {
                    if (obstacle == 0) {
                        ans = "NO";
                        return;
                    }

                    corridor[nx][ny] = 'O';
                    obstacle--;
                    break;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        corridor = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine().replace(" ", "");
            for (int j = 0; j < N; j++) {
                corridor[i][j] = str.charAt(j);
                if (corridor[i][j] == 'T') {
                    teacherPos.add(new int[]{i, j});
                }
            }
        }

        for (int[] teacher : teacherPos) {
            backTracking(teacher[0], teacher[1]);
        }

        System.out.println(ans);
    }

}
