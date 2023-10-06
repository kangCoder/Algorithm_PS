package simulation;

import java.util.*;
import java.io.*;

public class boj_1063_킹 {

    static String king, stone;
    static int N, kingR, kingC, stoneR, stoneC;

    static String make(int r, int c) {
        String tmp = "";
        tmp += (char)(c + 65);
        tmp += r;
        return tmp;
    }

    //1. 킹을 먼저 움직여서 범위 확인하고
    //2. 범위 안이라면 움직인 자리에 돌이 있는지 확인
    //없다면 그냥 움직이고 끝, 있다면 돌이 움직여서 범위 확인
    //돌도 범위 안이라면 둘 다 움직이고, 밖이라면 둘 다 안움직임
    static void move(String op) {
        switch (op) {
            case "R":
                if (kingC + 1 <= 7) {
                    if (!make(kingR, kingC + 1).equals(make(stoneR, stoneC))) {
                        kingC++;
                    } else {
                        if (stoneC + 1 <= 7) {
                            kingC++;
                            stoneC++;
                        }
                    }
                }
                break;
            case "L":
                if (kingC - 1 >= 0) {
                    if (!make(kingR, kingC - 1).equals(make(stoneR, stoneC))) {
                        kingC--;
                    } else {
                        if (stoneC - 1 >= 0) {
                            kingC--;
                            stoneC--;
                        }
                    }
                }
                break;
            case "B":
                if (kingR - 1 >= 1) {
                    if (!make(kingR - 1, kingC).equals(make(stoneR, stoneC))) {
                        kingR--;
                    } else {
                        if (stoneR - 1 >= 1) {
                            kingR--;
                            stoneR--;
                        }
                    }
                }
                break;
            case "T":
                if (kingR + 1 <= 8) {
                    if (!make(kingR + 1, kingC).equals(make(stoneR, stoneC))) {
                        kingR++;
                    } else {
                        if (stoneR + 1 <= 8) {
                            kingR++;
                            stoneR++;
                        }
                    }
                }
                break;
            case "RT":
                if (kingR + 1 <= 8 && kingC + 1 <= 7) {
                    if (!make(kingR + 1, kingC + 1).equals(make(stoneR, stoneC))) {
                        kingR++;
                        kingC++;
                    } else {
                        if (stoneR + 1 <= 8 && stoneC + 1 <= 7) {
                            kingR++;
                            kingC++;
                            stoneR++;
                            stoneC++;
                        }
                    }
                }
                break;
            case "LT":
                if (kingR + 1 <= 8 && kingC - 1 >= 0) {
                    if (!make(kingR + 1, kingC - 1).equals(make(stoneR, stoneC))) {
                        kingR++;
                        kingC--;
                    } else {
                        if (stoneR + 1 <= 8 && stoneC - 1 >= 0) {
                            kingR++;
                            kingC--;
                            stoneR++;
                            stoneC--;
                        }
                    }
                }
                break;
            case "RB":
                if (kingR - 1 >= 1 && kingC + 1 <= 7) {
                    if (!make(kingR - 1, kingC + 1).equals(make(stoneR, stoneC))) {
                        kingR--;
                        kingC++;
                    } else {
                        if (stoneR - 1 >= 1 && stoneC + 1 <= 7) {
                            kingR--;
                            kingC++;
                            stoneR--;
                            stoneC++;
                        }
                    }
                }
                break;
            case "LB":
                if (kingR - 1 >= 1 && kingC - 1 >= 0) {
                    if (!make(kingR - 1, kingC - 1).equals(make(stoneR, stoneC))) {
                        kingR--;
                        kingC--;
                    } else {
                        if (stoneR - 1 >= 1 && stoneC - 1 >= 0) {
                            kingR--;
                            kingC--;
                            stoneR--;
                            stoneC--;
                        }
                    }
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken();
        stone = st.nextToken();
        N = Integer.parseInt(st.nextToken());

        kingR = Character.getNumericValue(king.charAt(1));
        kingC = king.charAt(0) - 65;
        stoneR = Character.getNumericValue(stone.charAt(1));
        stoneC = stone.charAt(0) - 65;

        for (int i = 0; i < N; i++) {
            //System.out.println(i + "번째 king: " + make(kingR, kingC) + ", stone:" + make(stoneR, stoneC));
            String op = br.readLine();
            move(op);
        }

        System.out.println(make(kingR, kingC));
        System.out.println(make(stoneR, stoneC));
    }

}
