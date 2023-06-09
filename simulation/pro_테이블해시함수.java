package simulation;

import java.util.*;

public class pro_테이블해시함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        //col번째 열을 기준으로 오름차순 정렬
        //값이 동일하면 첫 번째 값 비교로 내림차순
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            } else {
                return a[col - 1] - b[col - 1];
            }
        });

        //i번째 행의 tuple의 각 컬럼의 값을 i로 나눈 나머지의 합 S_i
        int[] S = new int[row_end - row_begin + 1];
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //System.out.println(data[i][j] + " mod " + (i + 1));
                S[i - (row_begin - 1)] += data[i][j] % (i + 1);
            }
            //System.out.println("S=" + S[i - (row_begin - 1)]);
        }

        //S_i를 bitwise XOR
        if (S.length == 1) {
            return S[0];
        }

        int answer = S[0];
        for (int i = 1; i < S.length; i++) {
            answer ^= S[i];
        }

        return answer;
    }

}
