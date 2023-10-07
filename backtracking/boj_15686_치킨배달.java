package backtracking;

import java.util.*;
import java.io.*;

public class boj_15686_치킨배달 {

    static int N, M, ans = Integer.MAX_VALUE; //도시의 크기, 고를 치킨집의 수
    static int[][] city;
    static boolean[] safe;
    static List<Pos> chickens = new ArrayList<>();
    static List<Pos> houses = new ArrayList<>();

    static int countChickenDiff() {
        int cnt = 0;
        for (Pos house : houses) {
            int chickenDist = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (safe[i]) {
                    int dist = Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y);
                    chickenDist = Math.min(chickenDist, dist);
                }
            }
            cnt += chickenDist;
        }

        return cnt;
    }

    //0: 거리, 1: 집, 2: 치킨집, 3: 폐업 피킨집
    static void selectGoOut(int cur, int cnt) {
        //폐업할 치킨집 다 골랐으면 치킨거리 세기
        if (cnt == M) {
            ans = Math.min(ans, countChickenDiff());
            return;
        }

        for (int i = cur; i < chickens.size(); i++) {
            if (!safe[i]) {
                safe[i] = true;
                selectGoOut(i + 1, cnt + 1);
                safe[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                } else if (city[i][j] == 1) {
                    houses.add(new Pos(i, j));
                }
            }
        }

        safe = new boolean[chickens.size()];

        selectGoOut(0, 0);
        System.out.println(ans);
    }

    static class Pos {

        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
