package map;

import java.util.*;

public class pro_시소짝꿍 {

    public long solution(int[] weights) {
        long answer = 0;

        Map<Double, Integer> map = new HashMap<>(); //몸무게, 빈도수
        for (Integer w : weights) {
            map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);
        }

        //몸무게는 100~1000 범위이므로 여기까지 돌면서 있는지 센다.
        //몸무게 비교 (2:2, 2:3, 3:4)
        for (int i = 100; i <= 1000; i++) {
            double d = i * 1.0;
            if (map.containsKey(d)) {
                double d2 = d * 2;
                double d3 = d * 3 / 2;
                double d4 = d * 4 / 3;
                System.out.println("현재 몸무게=" + d + ", 2배=" + d2 + ", 2:3=" + d3 + ", 3:4=" + d4);
                long count = map.get(d); //몸무게가 i인 사람수
                answer += count * (count - 1) / 2; //같은 몸무게인 사람
                answer += count * map.getOrDefault(d2, 0); //몸무게 2배 차이 나는 사람
                answer += count * map.getOrDefault(d3, 0); //몸무게 2:3 비율
                answer += count * map.getOrDefault(d4, 0); //몸무게 3:4 비율
            }
        }

        return answer;
    }
}