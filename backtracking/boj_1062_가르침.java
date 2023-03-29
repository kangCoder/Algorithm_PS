package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1062_가르침 {

    static int N, K, max = 0;
    static String[] words;
    static boolean[] isUsed;

    static void backTracking(int length, int start) {
        if (length == K - 5) {
            //5개 알파벳은 이미 배웠으므로
            max = Math.max(max, studyWords());
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                backTracking(length + 1, i);
                isUsed[i] = false;
            }
        }
    }

    static int studyWords() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            char[] word = words[i].toCharArray();
            boolean flag = true;
            for (char c : word) {
                if (!isUsed[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N]; //남극언어의 N개의 단어
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = s.replace("anta", "");
            s = s.replace("tica", "");
            words[i] = s;
        }

        isUsed = new boolean[26]; //해당 알파벳을 사용했는가
        isUsed['a' - 'a'] = true;
        isUsed['n' - 'a'] = true;
        isUsed['t' - 'a'] = true;
        isUsed['i' - 'a'] = true;
        isUsed['c' - 'a'] = true; //a, n, t, i, c 5개는 이미 배운 것.

        if (K == 0) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        } else {
            backTracking(0, 0);
            System.out.println(max);
        }

    }

}
