package greedy.kakao_2022인턴십_두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0L, sum2 = 0L, totalSum = 0L;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }

        totalSum = sum1 + sum2;
        if (totalSum % 2 == 1) {
            return -1;
        }

        int sum = (int) totalSum / 2;
        int limit = queue1.length * 2;
        int point1 = 0, point2 = 0;
        while (point1 <= limit && point2 <= limit) {
            if (sum1 == sum) {
                return point1 + point2;
            }
            if (sum1 > sum) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
                point1++;
            } else {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
                point2++;
            }
        }

        return -1;
    }

}
