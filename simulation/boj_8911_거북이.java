package simulation;

import java.io.*;

public class boj_8911_거북이 {

    static final int E = 1, W = 2, S = 3, N = 4;
    static int maxX, minX, maxY, minY;
    static int[] cur = new int[2]; //0: 현재 x위치, 1: 현재 y위치

    static void init() {
        minX = minY = maxX = maxY = cur[0] = cur[1] = 0;
    }

    static void move(int dir, int fb) {
        //fb==1 -> 앞
        switch (dir) {
            case E:
                if (fb == 1) {
                    cur[0]++;
                    maxX = Math.max(maxX, cur[0]);
                } else {
                    cur[0]--;
                    minX = Math.min(minX, cur[0]);
                }
                break;
            case W:
                if (fb == 0) {
                    cur[0]++;
                    maxX = Math.max(maxX, cur[0]);
                } else {
                    cur[0]--;
                    minX = Math.min(minX, cur[0]);
                }
                break;
            case S:
                if (fb == 0) {
                    cur[1]--;
                    minY = Math.min(minY, cur[1]);
                } else {
                    cur[1]++;
                    maxY = Math.max(maxY, cur[1]);
                }
                break;
            case N:
                if (fb == 1) {
                    cur[1]--;
                    minY = Math.min(minY, cur[1]);
                } else {
                    cur[1]++;
                    maxY = Math.max(maxY, cur[1]);
                }
                break;
        }
    }

    static int turn(int cur, char dir) {
        switch (cur) {
            case E:
                if (dir == 'L') {
                    cur = N;
                } else {
                    cur = S;
                }
                break;
            case W:
                if (dir == 'L') {
                    cur = S;
                } else {
                    cur = N;
                }
                break;
            case S:
                if (dir == 'L') {
                    cur = E;
                } else {
                    cur = W;
                }
                break;
            case N:
                if (dir == 'L') {
                    cur = W;
                } else {
                    cur = E;
                }
                break;
        }

        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String control = br.readLine();
            int curDir = N; //초기에 북쪽을 보고 있는다.
            init();

            for (int i = 0; i < control.length(); i++) {
                char command = control.charAt(i);
                switch (command) {
                    case 'F':
                        move(curDir, 1);
                        break;
                    case 'B':
                        move(curDir, 0);
                        break;
                    case 'L':
                        curDir = turn(curDir, 'L');
                        break;
                    case 'R':
                        curDir = turn(curDir, 'R');
                        break;
                }
            }

            int x = Math.abs(maxX) + Math.abs(minX);
            int y = Math.abs(maxY) + Math.abs(minY);
            System.out.println(x * y);
        }
    }
}
