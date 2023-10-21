package simulation;

import java.util.*;
import java.io.*;

public class boj_10703_유성 {

    static int R, S;
    static char[][] photo;

    static int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < S; i++) {
            int cnt = 0;
            for (int j = 0; j < R; j++) {
                if (j + 1 < R && photo[j][i] == 'X' && photo[j + 1][i] == '.') {
                    for (int k = j + 1; k < R - 1; k++) {
                        if (photo[k][i] == '#') {
                            break;
                        } else if (photo[k][i] == 'X') {
                            //'ㄷ' 형태로 생긴 유성우일 수도 있음.
                            cnt = 0;
                            break;
                        } else {
                            cnt++;
                        }
                    }
                }

                if (cnt > 0 && photo[j][i] == '#') {
                    min = Math.min(min, cnt);
                    cnt = 0;
                }
            }
        }
        return min;
    }

    static void dropMeteor(int min) {
        for (int i = 0; i < S; i++) {
            for (int j = R - 1; j >= 0; j--) {
                if (photo[j][i] == 'X' && photo[j + min][i] == '.') {
                    char tmp = photo[j][i];
                    photo[j][i] = photo[j + min][i];
                    photo[j + min][i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        photo = new char[R][S];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < S; j++) {
                photo[i][j] = s.charAt(j);
            }
        }

        int min = getMin();
        dropMeteor(min);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(photo[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
