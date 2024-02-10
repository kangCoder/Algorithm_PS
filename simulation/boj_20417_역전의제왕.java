package simulation;

import java.io.*;
import java.util.*;

public class boj_20417_역전의제왕 {

    static int N, M;
    static Person[] people;
    static Map<Integer, List<int[]>> freezingMap = new HashMap<>(); //int[4]: [문제 번호, 제출 횟수, 패널티, 시간]

    static void refreshRank() {
        //조건대로 오름차순 정렬
        Arrays.sort(people, (a, b) -> {
            if (a.total < b.total) {
                return 1;
            } else if (a.total > b.total) {
                return -1;
            } else {
                if (a.penalty < b.penalty) {
                    return 1;
                } else if (a.penalty > b.penalty) {
                    return -1;
                } else {
                    return a.lastSubmitTime - b.lastSubmitTime;
                }
            }
        });

        //랭킹 갱신
        for (int i = 1; i <= N; i++) {
            if (people[people[i].number].rank != 0 && people[people[i].number].rank > i) {
                people[people[i].number].xRP += people[people[i].number].rank - i;
            }
            people[people[i].number].rank = i;
        }
    }

    static int[] findSubmit(int n) {
        List<int[]> submitList = freezingMap.get(n);
        if (submitList.size() > 1) {
            submitList.sort(Comparator.comparingInt(a -> a[0])); //문제 번호가 빠른 순으로 정렬
        }
        return submitList.remove(0);
    }

    static int findLastPlace() {
        for (int i = N; i >= 1; i--) {
            for (Integer n : freezingMap.keySet()) {
                if (people[i].number == n) {
                    return n;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new Person[N + 1];
        for (int i = 0; i <= N; i++) {
            people[i] = new Person(i); //초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            int n = Integer.parseInt(st.nextToken()); //참가자 번호
            int proN = Integer.parseInt(st.nextToken()); //문제 번호
            int submitN = Integer.parseInt(st.nextToken()); //제출 횟수

            //패널티 = (시간(분)) + (제출 횟수 - 1) * 20
            int penalty = ((time / 100) * 60) + (time % 100) + ((submitN - 1) * 20);

            //3시 이전 제출이면 갱신
            if (time <= 300) {
                //맞은 문제에 대해 총점 + 1
                people[n].total++;

                //해당 문제에 대해 패널티와 제출 횟수 갱신
                people[n].problems[proN][0] = submitN;
                people[n].problems[proN][1] = penalty;
                people[n].penalty += penalty;

                //마지막 제출 시간 갱신
                people[n].lastSubmitTime = time;
            } else {
                //3시 이후는 프리징 -> 참가자 별로 제출한 것을 미리 저장
                //저장할 사항: 문제 번호, 제출 횟수, 패널티, 시간
                int[] freeze = new int[4];
                freeze[0] = proN;
                freeze[1] = submitN;
                freeze[2] = penalty;
                freeze[3] = time;

                if (!freezingMap.containsKey(n)) {
                    freezingMap.put(n, new ArrayList<>());
                }

                List<int[]> list = freezingMap.get(n);
                list.add(freeze);
                freezingMap.put(n, list);
            }
        }

        //초기 랭킹
        refreshRank();

        //언프리징
        while (!freezingMap.isEmpty()) {
            for (int i = 1; i <= N; i++) {
                System.out.println(i + "번 참가자");
                System.out.println("총점: " + people[i].total + ", 패널티: " + people[i].penalty + ", 역전 스코어: " + people[i].xRP);
            }

            //순위가 가장 낮은 사람(총점이 가장 낮은 사람)의 제출 리스트를 꺼내고
            //그 사람의 제출중 번호가 가장 빠른 제출을 찾는다 -> 그 제출을 반영하고 다시 랭킹 세우기
            int lastN = findLastPlace(); //현재 프리징맵에 남아 있는 제출자 중 가장 랭킹이 낮은 사람찾기
            int[] submit = findSubmit(lastN);

            //해당 제출 반영
            people[lastN].total++;
            people[lastN].lastSubmitTime = submit[3];
            people[lastN].problems[submit[0]][0] = submit[1];
            people[lastN].problems[submit[0]][1] = submit[2];
            people[lastN].penalty += submit[2];

            //프리징에서 해당 사람 제출이 더이상 없으면 지워버리기
            if (freezingMap.get(lastN).isEmpty()) {
                freezingMap.remove(lastN);
            }

            //랭킹, 역전 포인트 갱신
            refreshRank();
        }
    }

    static class Person {

        //참가자 번호, 각 문제에 대한 제출이력 배열, 총점, 패널티, 역전 포인트, 랭킹
        int number, total, penalty, xRP, lastSubmitTime, rank;

        public Person(int number) {
            this.number = number;
        }

        int[][] problems = new int[14][2]; //[제출 횟수, 패널티]
    }
}
