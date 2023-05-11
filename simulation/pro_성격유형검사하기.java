package simulation;

import java.util.*;

public class pro_성격유형검사하기 {

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);

        //1: 매우 비동의, 7: 매우 동의
        for (int i = 0; i < survey.length; i++) {
            char low = survey[i].charAt(0);
            char high = survey[i].charAt(1);

            switch (choices[i]) {
                case 1:
                    map.put(low, map.get(low) + 3);
                    break;
                case 2:
                    map.put(low, map.get(low) + 2);
                    break;
                case 3:
                    map.put(low, map.get(low) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(high, map.get(high) + 1);
                    break;
                case 6:
                    map.put(high, map.get(high) + 2);
                    break;
                case 7:
                    map.put(high, map.get(high) + 3);
                    break;
            }
        }

        if (map.get('T') > map.get('R')) {
            answer.append('T');
        } else {
            answer.append('R');
        }
        if (map.get('F') > map.get('C')) {
            answer.append('F');
        } else {
            answer.append('C');
        }
        if (map.get('M') > map.get('J')) {
            answer.append('M');
        } else {
            answer.append('J');
        }
        if (map.get('N') > map.get('A')) {
            answer.append('N');
        } else {
            answer.append('A');
        }

        return answer.toString();
    }

}
