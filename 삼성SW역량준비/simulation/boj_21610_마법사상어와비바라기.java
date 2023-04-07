package 삼성SW역량준비.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21610_마법사상어와비바라기 {

    static int N, M, cloudSize = 0;
    static int[][] grid, cloudMap;
    static Cloud[] clouds;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void initCloud() {
        clouds = new Cloud[50 * 50];
        createCloud(N - 2, 0);
        createCloud(N - 2, 1);
        createCloud(N - 1, 0);
        createCloud(N - 1, 1);
    }

    public static void createCloud(int x, int y) {
        clouds[cloudSize++] = new Cloud(x, y);
    }

    public static void moveCloud(int dir, int s) {
        //dir방향으로 s번 움직이기 (dir * s)
        //N에 비례하는 큰 수를 더하면 dist 값이 항상 양수 값이 된다. (N * 50)
        int distX = (dx[dir] * s) + (N * 50);
        int distY = (dy[dir] * s) + (N * 50);

        //그 후 모듈러 연산
        for (int i = 0; i < cloudSize; i++) {
            clouds[i].x = (distX + clouds[i].x) % N;
            clouds[i].y = (distY + clouds[i].y) % N;
        }
    }

    public static void increaseWater() {
        for (int i = 0; i < cloudSize; i++) {
            grid[clouds[i].x][clouds[i].y]++;
        }
    }

    public static void deleteCloud() {
        cloudMap = new int[N][N];
        for (int i = 0; i < cloudSize; i++) {
            cloudMap[clouds[i].x][clouds[i].y] = 1; //여기에 구름이 있었다.
        }
        cloudSize = 0;
    }

    public static void copyBug() {
        int[][] waterIncrease = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloudMap[i][j] == 1) {
                    int cnt = 0;
                    for (int dir = 1; dir < 8; dir += 2) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }

                        if (grid[nx][ny] >= 1) {
                            cnt++;
                        }
                    }
                    waterIncrease[i][j] = cnt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] += waterIncrease[i][j];
            }
        }
    }

    public static void generateCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] >= 2 && cloudMap[i][j] == 0) {
                    grid[i][j] -= 2;
                    createCloud(i, j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //처음에 왼쪽 아래 4개의 격자에 구름 생성.
        initCloud();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveCloud(dir - 1, s);
            increaseWater();
            deleteCloud();
            copyBug();
            generateCloud();
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += grid[i][j];
            }
        }

        System.out.println(cnt);
    }

    static class Cloud {

        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
