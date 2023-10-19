package backtracking;

import java.util.*;
import java.io.*;

public class boj_1038_감소하는수 {

    static int N;
    static List<Long> list = new ArrayList<>();

    //감소하는 수의 최댓값은 9876543210
    //0,1,2,3,4,5,6,7,8,9 -> 총 10개의 수를 뽑아서 만들 수 있는 경우의 수 - 0만 뽑는 경우 - 안뽑는 경우 => 2^10 - 2 = 1022
    //N의 최댓값은 1023이고, 그 이상은 나올 수가 없음.
    static void backTracking(long n, int depth) {
        //11자리 이상 나올 수 없음
        if (depth > 10) {
            return;
        }

        list.add(n);

        for (int i = 0; i < 10; i++) {
            if (n % 10 > i) {
                backTracking((n * 10) + i, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N <= 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                backTracking(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }
}
