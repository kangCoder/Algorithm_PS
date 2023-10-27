package map;

import java.util.*;
import java.io.*;

public class boj_19583_싸이버개강총회 {

    static int start, end, readEnd;
    static Map<String, Integer> attendMap = new HashMap<>();
    static Set<String> attend = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        end = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        readEnd = Integer.parseInt(st.nextToken().replaceAll(":", ""));

        String chat = null;
        while ((chat = br.readLine()) != null) {
            String[] par = chat.split(" ");

            String person = par[1];
            int time = Integer.parseInt(par[0].replaceAll(":", ""));

            if (!attendMap.containsKey(person)) {
                if (time <= start) {
                    attendMap.put(person, time);
                }
            } else {
                if (end <= time && time <= readEnd) {
                    attend.add(person);
                }
            }
        }

        System.out.println(attend.size());
    }
}
