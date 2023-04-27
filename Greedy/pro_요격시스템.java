package greedy;

import java.util.*;

public class pro_요격시스템 {

    public int solution(int[][] targets) {
        int answer = 0;

        //종점을 기준으로 정렬
        Arrays.sort(targets, (t1, t2) -> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            } else {
                return t1[1] - t2[1];
            }
        });

        int end = targets[0][1]; //첫 번째 종점
        answer++; //첫 번째 종점에 요격 시스템 설치

        for (int[] target : targets) {
            //그 다음 시점이 전의 종점보다 멀리 떨어진 경우 -> 겹치지 않는 경우
            if (target[0] >= end) {
                end = target[1]; //종점 옮기고
                answer++; //요격 시스템 추가 설치
            }
        }

        return answer;
    }
}
