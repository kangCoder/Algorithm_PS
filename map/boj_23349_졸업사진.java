package map;

import java.util.*;
import java.io.*;

public class boj_23349_졸업사진 {

    static int N, start, end;

    private static int getMaxTime(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            max = Math.max(max, n);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<String> names = new ArrayList<>();
        List<String> places = new ArrayList<>();
        List<Place> maxPlaces = new ArrayList<>();
        Map<String, int[]> placeTimeMap = new HashMap<>(); //<장소, 시간대>

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String place = st.nextToken();
            int startT = Integer.parseInt(st.nextToken());
            int endT = Integer.parseInt(st.nextToken());

            if (names.contains(name)) {
                continue;
            }
            names.add(name);

            if (!placeTimeMap.containsKey(place)) {
                placeTimeMap.put(place, new int[50001]); //시간은 50,000까지임
            }

            int[] curT = placeTimeMap.get(place);
            for (int x = startT; x < endT; x++) {
                curT[x]++;
            }

            if (maxPlaces.isEmpty()) {
                maxPlaces.add(new Place(place, 1));
            } else {
                int maxCnt = getMaxTime(curT);
                Place maxPlaceEntry = maxPlaces.remove(maxPlaces.size() - 1);
                if (maxPlaceEntry.cnt < maxCnt) {
                    maxPlaceEntry.cnt = maxCnt;
                    maxPlaceEntry.name = place;
                    maxPlaces.clear();
                } else if (maxPlaceEntry.cnt == maxCnt) {
                    maxPlaces.add(new Place(place, maxCnt));
                }
                maxPlaces.add(maxPlaceEntry);
            }
            if (!places.contains(place)) {
                places.add(place);
            }
        }

        String maxName = "";
        int max;
        if (maxPlaces.size() != 1) {
            maxPlaces.sort(Comparator.comparing(a -> a.name));
        }
        max = maxPlaces.get(0).cnt;
        maxName = maxPlaces.get(0).name;

        for (int i = 0; i < 50001; i++) {
            if (placeTimeMap.get(maxName)[i] == max) {
                start = i;
                break;
            }
        }

        for (int i = start; i < 50001; i++) {
            if (placeTimeMap.get(maxName)[i] != max) {
                end = i;
                break;
            }
        }

        System.out.println(maxName + " " + start + " " + end);
    }

    static class Place {

        String name;
        int cnt;

        public Place(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }
}
