package map;

import java.util.*;

public class pro_달리기경주 {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int a = map.get(callings[i]);

            map.put(players[a], a - 1);
            map.put(players[a - 1], a);

            String tmp = players[a];
            players[a] = players[a - 1];
            players[a - 1] = tmp;
        }

        return players;
    }
}
