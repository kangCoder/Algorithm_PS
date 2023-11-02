package simulation;

import java.io.*;
import java.util.*;

public class soft_회의실예약 {

  static int N, M;
  static Map<String, boolean[]> roomsMap = new HashMap<>();

  static List<String> availableTimeList(String room) {
    List<String> list = new ArrayList<>();

    boolean[] time = roomsMap.get(room);
    for (int i = 9; i < 18; i++) {
      if (!time[i]) {
        int j = i + 1;
        while (!time[j] && j < 18) {
          j++;
        }
        if (i < 10) {
          list.add("0" + i + "-" + j);
        } else {
          list.add(i + "-" + j);
        }
        i = j;
      }
    }

    return list;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      String room = br.readLine();
      roomsMap.put(room, new boolean[19]);
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String room = st.nextToken();
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      boolean[] time = roomsMap.get(room);
      for (int t = start; t < end; t++) {
        time[t] = true;
      }

      roomsMap.put(room, time);
    }

    List<String> roomList = new ArrayList<>(roomsMap.keySet());
    Collections.sort(roomList);
    for (int i = 0; i < roomList.size(); i++) {
      System.out.println("Room " + roomList.get(i) + ":");

      List<String> tmp = availableTimeList(roomList.get(i));
      if (tmp.isEmpty()) {
        System.out.println("Not available");
      } else {
        System.out.println(tmp.size() + " available:");
        for (String room : tmp) {
          System.out.println(room);
        }
      }

      if (i < roomList.size() - 1) {
        System.out.println("-----");
      }
    }
  }
}

