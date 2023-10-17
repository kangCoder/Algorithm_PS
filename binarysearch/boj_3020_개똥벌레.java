package binarysearch;

import java.util.*;
import java.io.*;

public class boj_3020_개똥벌레 {

    static int N, H, min, cnt; //동굴의 길이(짝수), 높이, 최솟값, 개수
    static int[] stalagmites, stalactites; //석순, 종유석

    static int lowerBound(int[] arr, int target) {
        int start = 0, end = arr.length, mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        //target보다 크거나 같은걸 찾았다? -> 그 위의 것들을 다 부수기 때문에 end가 아니라 len-end
        return arr.length - end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        //석순-종유석 순으로 번갈아가며 등장
        stalagmites = new int[N / 2];
        stalactites = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            stalagmites[i] = Integer.parseInt(br.readLine());
            stalactites[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stalagmites);
        Arrays.sort(stalactites);

        min = Integer.MAX_VALUE;
        cnt = 0;
        for (int i = 1; i <= H; i++) {
            //i층에 부딪히는 석순, 종유석이 각각 몇개인지 이분탐색으로 찾기.
            //i층에 부딪히는 석순, 종유석이 없을 수도 있기 때문에 lower_bound로 탐색한다.
            int destroy = lowerBound(stalagmites, i) + lowerBound(stalactites, H - i + 1); //종유석은 위에서 아래로 떨어지기 때문에 H-i+1

            //찾았으면 최소인지 갱신
            if (min == destroy) {
                cnt++;
                continue;
            }
            if (min > destroy) {
                min = destroy;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);
    }

}
