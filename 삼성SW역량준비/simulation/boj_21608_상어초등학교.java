package 삼성SW역량준비.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21608_상어초등학교 {

    static int N, ans = 0;
    static Student[] students;
    static int[][] seats;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int getPoint(int x, int y, int i) {
        int point = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (seats[nx][ny] == 0) {
                point++;
            } else {
                for (int f = 0; f < 4; f++) {
                    if (seats[nx][ny] == students[i].friends[f]) {
                        point += 10;
                    }
                }
            }
        }

        return point;
    }

    public static void setStudent(int x, int y, int i) {
        students[i].x = x;
        students[i].y = y;
        seats[x][y] = students[i].num;
    }

    public static int calPoint(int i) {
        int point = 0;
        int x = students[i].x, y = students[i].y;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            for (int f = 0; f < 4; f++) {
                if (seats[nx][ny] == students[i].friends[f]) {
                    if (point == 0) {
                        point++;
                    } else {
                        point *= 10;
                    }
                }
            }
        }

        return point;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        seats = new int[N][N];
        students = new Student[N * N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int stuNum = Integer.parseInt(st.nextToken());

            int[] friends = new int[4];
            for (int j = 0; j < 4; j++) {
                friends[j] = Integer.parseInt(st.nextToken());
            }

            students[i] = new Student(stuNum, friends);
        }

        //학생 배치
        for (int i = 0; i < N * N; i++) {
            int tmpX = -1, tmpY = -1, point = -1;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (seats[x][y] == 0) {
                        int curPoint = getPoint(x, y, i);
                        if (point < curPoint) {
                            tmpX = x;
                            tmpY = y;
                            point = curPoint;
                        }
                    }
                }
            }
            setStudent(tmpX, tmpY, i);
        }

        int cnt = 0;
        for (int i = 0; i < N * N; i++) {
            cnt += calPoint(i);
        }

        System.out.println(cnt);
    }

    static class Student {

        int num;
        int x, y;
        int[] friends;

        public Student(int num, int[] friends) {
            this.num = num;
            this.friends = friends;
        }
    }

}
