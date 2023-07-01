package 삼성SW역량준비.simulation;

import java.util.*;
import java.io.*;

public class codetree_정육면체굴리기 {

    static int n, m, x, y, k;
    static int[] roll;
    static int[][] grid;
    static int[] dice = new int[7];
    //   3
    // 2 1 5 6
    //   4

    static void diceInit() {
        //주사위 초기상태
        if (grid[x][y] != 0) {
            dice[6] = grid[x][y];
            grid[x][y] = 0;
        } else {
            grid[x][y] = dice[6];
        }
    }

    static void east() {
        y++;

        //주사위 오른쪽으로 굴리기
        //값 변경: 2->1, 6->2, 5->6, 1->5
        int tmp1 = dice[1], tmp2 = dice[2], tmp5 = dice[5], tmp6 = dice[6];
        dice[1] = tmp2;
        dice[2] = tmp6;
        dice[5] = tmp1;
        dice[6] = tmp5;

        diceInit();
    }

    static void west() {
        y--;

        //주사위 왼쪽으로 굴리기
        //값 변경: 1->2, 2->6, 6->5, 5->1
        int tmp1 = dice[1], tmp2 = dice[2], tmp5 = dice[5], tmp6 = dice[6];
        dice[1] = tmp5;
        dice[2] = tmp1;
        dice[5] = tmp6;
        dice[6] = tmp2;

        diceInit();
    }

    static void north() {
        x--;

        //주사위 위로 굴리기
        //값 변경: 4->1, 1->3, 3->6, 6->4
        int tmp1 = dice[1], tmp3 = dice[3], tmp4 = dice[4], tmp6 = dice[6];
        dice[1] = tmp4;
        dice[3] = tmp1;
        dice[4] = tmp6;
        dice[6] = tmp3;

        diceInit();
    }

    static void south() {
        x++;

        //주사위 아래로 굴리기
        //값 변경: 1->4, 3->1, 6->3, 4->6
        int tmp1 = dice[1], tmp3 = dice[3], tmp4 = dice[4], tmp6 = dice[6];
        dice[1] = tmp3;
        dice[3] = tmp6;
        dice[4] = tmp1;
        dice[6] = tmp4;

        diceInit();
    }

    static void moveDice(int dir) {
        //1:동쪽, 2:서쪽, 3:북쪽, 4:남쪽
        switch (dir) {
            case 1:
                if (y + 1 >= m) {
                    break;
                }
                east();
                System.out.println(dice[1]);
                break;
            case 2:
                if (y - 1 < 0) {
                    break;
                }
                west();
                System.out.println(dice[1]);
                break;
            case 3:
                if (x - 1 < 0) {
                    break;
                }
                north();
                System.out.println(dice[1]);
                break;
            case 4:
                if (x + 1 >= n) {
                    break;
                }
                south();
                System.out.println(dice[1]);
                break;
        }
    }

    static void solution() {
        //바닥이 0 -> 주사위 바닥면의 숫자가 바닥으로 복사
        //바닥이 0이 아님 -> 바닥의 숫자가 주사위 바닥면으로 복사, 바닥은 0이 됨
        diceInit();

        for (int i = 0; i < roll.length; i++) {
            int dir = roll[i]; //1:동쪽, 2:서쪽, 3:북쪽, 4:남쪽
            moveDice(dir);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //말판의 세로
        m = Integer.parseInt(st.nextToken()); //말판의 가로
        x = Integer.parseInt(st.nextToken()); //주사위 초기 위치
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); //굴리기 횟수

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roll = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            roll[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}