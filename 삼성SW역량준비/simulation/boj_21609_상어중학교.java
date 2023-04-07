package 삼성SW역량준비.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_21609_상어중학교 {

    static int N, M;
    static int[][] grid;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static int calcPoint() {
        int pt = 0;
        List<Block> maxArea = new ArrayList<>();
        int maxRainbow = 0;

        for (int color = 1; color <= M; color++) {
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //각 color 마다 만들 수 있는 최대 블록 그룹 찾기
                    if (!visited[i][j] && grid[i][j] == color) {
                        Queue<Block> queue = new LinkedList<>();
                        List<Block> pos = new ArrayList<>();
                        int rainbow = 0;

                        Block block = new Block(i, j);
                        queue.add(block);
                        pos.add(block); //pos(0)이 기준 좌표
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            Block b = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nx = b.x + dx[dir];
                                int ny = b.y + dy[dir];

                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                    continue;
                                }

                                if (!visited[nx][ny] && (grid[nx][ny] == color || grid[nx][ny] == 0)) {
                                    Block newBlock = new Block(nx, ny);
                                    queue.add(newBlock);
                                    pos.add(newBlock);
                                    visited[nx][ny] = true;

                                    if (grid[nx][ny] == 0) {
                                        rainbow++;
                                    }
                                }
                            }
                        }

                        //최대 블록 그룹 정하기 (1순위: 사이즈, 2순위: 무지개 개수, 3순위: 행이 큰거, 4순위: 열이 큰거)
                        if (maxArea.size() < pos.size() || (maxArea.size() == pos.size() && maxRainbow < rainbow)) {
                            maxArea = pos;
                            maxRainbow = rainbow;
                        } else if (maxArea.size() == pos.size() && maxRainbow == rainbow) {
                            if (maxArea.get(0).x < pos.get(0).x) {
                                maxArea = pos;
                            } else if (maxArea.get(0).x == pos.get(0).x) {
                                if (maxArea.get(0).y < pos.get(0).y) {
                                    maxArea = pos;
                                }
                            }
                        }
                    }
                }
            }
        }

        //최대 블록 그룹 찾았으면 점수 갱신.
        if (maxArea.size() >= 2) {
            pt = maxArea.size() * maxArea.size();

            for (int i = 0; i < maxArea.size(); i++) {
                int x = maxArea.get(i).x;
                int y = maxArea.get(i).y;
                grid[x][y] = -99;
            }
        }

        return pt;
    }

    //배열 아래로 떨구기
    public static void down() {
        for (int j = 0; j < N; j++) {
            int blank = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] == -99) {
                    blank++;
                } else if (grid[i][j] == -1) {
                    blank = 0;
                } else {
                    if (blank != 0) {
                        grid[i + blank][j] = grid[i][j];
                        grid[i][j] = -99;
                    }
                }
            }
        }
    }

    public static void rotate() {
        int[][] backUp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                backUp[N - 1 - j][i] = grid[i][j]; //반시계 방향으로 배열 90도 회전
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = backUp[i][j];
            }
        }
    }

    public static int solution() {
        int totalPoint = 0;
        int curPoint = 0;

        do {
            curPoint = calcPoint();
            totalPoint += curPoint;

            down();
            rotate();
            down();
        } while (curPoint != 0);

        return totalPoint;
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

        int ans = solution();
        System.out.println(ans);
    }

    static class Block {

        int x, y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
