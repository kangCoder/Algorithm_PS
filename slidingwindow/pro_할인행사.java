package slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class pro_할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int total = Arrays.stream(number).sum();
        Deque<String> days = new LinkedList<>(Arrays.asList(discount).subList(0, total));

        for (int i = total; i <= discount.length; i++) {
            boolean pass = IntStream.range(0, want.length).noneMatch(j -> Collections.frequency(days, want[j]) != number[j]);

            if (pass) {
                answer++;
            }

            if (i < discount.length) {
                days.pollFirst();
                days.addLast(discount[i]);
            }
        }

        return answer;
    }

}