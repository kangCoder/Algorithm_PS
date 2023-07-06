package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_25974_선물할인 {

    static int n, b, a, ans = 0;
    static int[] gifts;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //선물의 개수
        b = Integer.parseInt(st.nextToken()); //예산
        a = Integer.parseInt(st.nextToken()); //반값 할인을 받을 수 있는 최대 선물의 수
        gifts = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gifts.length; i++) {
            gifts[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gifts);
        int sum = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (sum + gifts[i] <= b) {
                sum += gifts[i];
                ans++;
            } else {
                //현재 i번째 선물을 사려니 예산 초과
                //-> i번째부터 절반씩 깎아보고 넣을 수 있는지 확인하기

                boolean flag = false;
                for (int j = i; j >= 0; j--) {
                    if (a <= 0) {
                        break;
                    }

                    //j번째 선물을 이미 절반 깎았는지 여부
                    if (check[j]) {
                        continue;
                    }
                    sum -= gifts[j] / 2;
                    a--;
                    check[j] = true;

                    //j번째 선물 가격을 절반 깎았을 때 i번째 선물을 살 수 있는지 확인
                    if (sum + gifts[i] <= b) {
                        sum += gifts[i];
                        ans++;
                        flag = true;
                        break;
                    }
                }

                //i번째 선물을 못샀다 -> 그 다음도 못산다는 뜻 -> 종료
                if (!flag) {
                    break;
                }
            }
        }

        System.out.println(ans);
    }

}