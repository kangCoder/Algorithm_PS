package simulation;

import java.io.*;

public class boj_2140_지뢰찾기 {

    static int N, ans = 0;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                boolean flag = true;

                for (int dir = 0; dir < 8; dir++) {
                    int nx = j + dx[dir];
                    int ny = i + dy[dir];

                    if (map[ny][nx] == '0') {
                        map[i][j] = 'O';
                        flag = false;
                        break;
                    }
                }

                //해당 칸에 지뢰가 있다 -> 주변 8칸에 0 이상의 수가 있다면, 하나씩 깎는다.
                if (flag) {
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = j + dx[dir];
                        int ny = i + dy[dir];

                        if (Character.getNumericValue(map[ny][nx]) > 0) {
                            map[ny][nx]--;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == '#') {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
