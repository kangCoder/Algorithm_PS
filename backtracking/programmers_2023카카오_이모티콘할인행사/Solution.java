package backtracking.programmers_2023카카오_이모티콘할인행사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Solution {

    public static Vector<Integer> tempSale = new Vector<>(); //세일할 임시 배열
    public static int maxCount = Integer.MIN_VALUE, maxProfit = Integer.MIN_VALUE;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        makeSales(0, users, emoticons);
        answer[0] = maxCount;
        answer[1] = maxProfit;

        return answer;
    }

    public static void makeSales(int length, int[][] users, int[] emoticons) {
        if (length == emoticons.length) {
            calculatePrice(users, emoticons);
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            tempSale.add(i);
            makeSales(length + 1, users, emoticons);
            tempSale.remove(tempSale.size() - 1);
        }
    }

    public static void calculatePrice(int[][] users, int[] emoticons) {
        int emoticonPlus = 0;
        int profit = 0;

        for (int[] user : users) {
            int sum = 0;
            for (int i = 0; i < tempSale.size(); i++) {
                if (user[0] > tempSale.get(i)) {
                    continue;
                }
                sum += (emoticons[i] / 100) * (100 - tempSale.get(i)); //할인 비율이 기준을 넘으면 구매
            }

            //합계가 가격 기준을 넘어가면 이모티콘 플러스로 돌리기
            if (sum >= user[1]) {
                emoticonPlus++;
            } else {
                profit += sum;
            }
        }

        //현재 이모티콘 플러스가 최대를 못넘으면 그냥 리턴
        if (maxCount > emoticonPlus) {
            return;
        }
        //이모티콘 플러스가 같더라도 수익이 같거나 작으면 그냥 리턴
        if (maxCount == emoticonPlus && maxProfit >= profit) {
            return;
        }

        maxCount = emoticonPlus;
        maxProfit = profit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] users = new int[n][2]; // [비율, 가격]
        int[] emoticons = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int percent = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            users[i][0] = percent;
            users[i][1] = price;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            emoticons[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = solution(users, emoticons);
        for (int an : ans) {
            System.out.println(an);
        }
    }


}
