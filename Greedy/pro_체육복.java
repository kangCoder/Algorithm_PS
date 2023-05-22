package greedy;

import java.util.*;

public class pro_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        //정렬해줘야 그리디하게 해결할 수 있음.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //lost == reserve인 경우 2개 가져온 사람이 도난당한 것 => 1개.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        //lost인 사람은 +-1인 사람한테 빌릴 수 있음.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }

        return answer;
    }

}
