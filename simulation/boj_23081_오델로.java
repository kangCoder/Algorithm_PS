package simulation;

import java.io.*;

public class boj_23081_오델로 {

    static int N;
    static int[] ans = new int[3]; //[개수, x좌표, y좌표]
    static char[][] plate;

    static int checkCountFlipWhite(int x, int y) {
        int total = 0, cnt = 0;

        //상
        for (int i = y; i >= 0; i--) {
            if (i != y && plate[i][x] == '.') {
                break;
            }

            if (plate[i][x] == 'W') {
                cnt++;
            } else if (plate[i][x] == 'B') {
                total += cnt;
                break;
            }
        }

        //우상
        cnt = 0;
        for (int i = 0; i < N; i++) {
            int ny = y, nx = x;
            ny -= i;
            nx += i;

            if (ny < 0 || nx >= N) {
                break;
            }
            if (ny != y && nx != x && plate[ny][nx] == '.') {
                break;
            }

            if (plate[ny][nx] == 'W') {
                cnt++;
            } else if (plate[ny][nx] == 'B') {
                total += cnt;
                break;
            }
        }

        //우
        cnt = 0;
        for (int i = x; i < N; i++) {
            if (i != x && plate[y][i] == '.') {
                break;
            }

            if (plate[y][i] == 'W') {
                cnt++;
            } else if (plate[y][i] == 'B') {
                total += cnt;
                break;
            }
        }

        //우하
        cnt = 0;
        for (int i = 0; i < N; i++) {
            int ny = y, nx = x;
            ny += i;
            nx += i;

            if (ny >= N || nx >= N) {
                break;
            }
            if (ny != y && nx != x && plate[ny][nx] == '.') {
                break;
            }

            if (plate[ny][nx] == 'W') {
                cnt++;
            } else if (plate[ny][nx] == 'B') {
                total += cnt;
                break;
            }
        }

        //하
        cnt = 0;
        for (int i = y; i < N; i++) {
            if (i != y && plate[i][x] == '.') {
                break;
            }

            if (plate[i][x] == 'W') {
                cnt++;
            } else if (plate[i][x] == 'B') {
                total += cnt;
                break;
            }
        }

        //좌하
        cnt = 0;
        for (int i = 0; i < N; i++) {
            int ny = y, nx = x;
            ny += i;
            nx -= i;

            if (ny >= N || nx < 0) {
                break;
            }
            if (ny != y && nx != x && plate[ny][nx] == '.') {
                break;
            }

            if (plate[ny][nx] == 'W') {
                cnt++;
            } else if (plate[ny][nx] == 'B') {
                total += cnt;
                break;
            }
        }

        //좌
        cnt = 0;
        for (int i = x; i >= 0; i--) {
            if (i != x && plate[y][i] == '.') {
                break;
            }

            if (plate[y][i] == 'W') {
                cnt++;
            } else if (plate[y][i] == 'B') {
                total += cnt;
                break;
            }
        }

        //좌상
        cnt = 0;
        for (int i = 0; i < N; i++) {
            int ny = y, nx = x;
            ny -= i;
            nx -= i;

            if (ny < 0 || nx < 0) {
                break;
            }
            if (ny != y && nx != x && plate[ny][nx] == '.') {
                break;
            }

            if (plate[ny][nx] == 'W') {
                cnt++;
            } else if (plate[ny][nx] == 'B') {
                total += cnt;
                break;
            }
        }

        return total;
    }

    static void solve() {
        //판을 돌면서 각 . 칸에 대해 8방향 탐색.
        //각 방향에 대해서 검은돌을 넣었을 때 흰돌을 몇 개 뒤집을 수 있을지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (plate[i][j] == '.') {
                    int cnt = checkCountFlipWhite(j, i);
                    if (ans[0] < cnt) {
                        ans[0] = cnt;
                        ans[1] = j;
                        ans[2] = i;
                    } else if (ans[0] == cnt) {
                        //개수가 동일하면 y좌표가 작은거
                        if (ans[2] > i) {
                            ans[1] = j;
                            ans[2] = i;
                        } else if (ans[2] == i) {
                            //y좌표까지 같으면 x좌표가 작은거
                            if (ans[1] > j) {
                                ans[1] = j;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        plate = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                plate[i][j] = s.charAt(j);
            }
        }

        solve();
        if (ans[0] == 0) {
            System.out.println("PASS");
        } else {
            System.out.println(ans[1] + " " + ans[2]);
            System.out.println(ans[0]);
        }
    }
}
