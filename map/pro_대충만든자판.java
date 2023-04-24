package map;

import java.util.*;

public class pro_대충만든자판 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        //알파벳을 누르는데 최소 횟수를 미리 세놓기
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : keymap) {
            String[] alphabets = key.split("");
            for (int i = 0; i < alphabets.length; i++) {
                int idx = map.getOrDefault(alphabets[i], i + 1);
                map.put(alphabets[i], Math.min(idx, i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String[] t = targets[i].split("");

            for (int j = 0; j < t.length; j++) {
                if (map.containsKey(t[j])) {
                    answer[i] += map.get(t[j]);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
