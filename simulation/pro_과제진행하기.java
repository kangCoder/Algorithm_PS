package simulation;

import java.util.*;

public class pro_과제진행하기 {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<Plan> stopList = new Stack<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>();

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String[] s = plans[i][1].split(":");
            int h = Integer.parseInt(s[0]) * 60;
            int m = Integer.parseInt(s[1]);
            int start = h + m;
            int playtime = Integer.parseInt(plans[i][2]);
            pq.offer(new Plan(name, start, playtime));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Plan cur = pq.poll();
            int curTime = cur.start;

            //현재 하고있는 과제와 다음 과제의 비교
            if (!pq.isEmpty()) {
                Plan nxt = pq.peek();

                //현재 과제가 더 빨리 끝난다면 현재 과제를 마무리.
                if (cur.start + cur.playtime < nxt.start) {
                    answer[idx++] = cur.name;
                    curTime += cur.playtime;

                    //현재 과제를 끝냈다면, 멈춰둔 과제를 이어서 진행
                    while (!stopList.isEmpty()) {
                        Plan remain = stopList.pop();

                        if (curTime + remain.playtime <= nxt.start) {
                            answer[idx++] = remain.name;
                            curTime += remain.playtime;
                            continue;
                        } else {
                            int remainTime = remain.playtime - (nxt.start - curTime);
                            stopList.push(new Plan(remain.name, remain.start, remainTime));
                            break;
                        }
                    }
                } else if (cur.start + cur.playtime == nxt.start) {
                    //현재 과제가 끝남과 동시에 새로운 과제가 들어온다.
                    answer[idx++] = cur.name;
                    continue;
                } else {
                    //현재 과제가 안끝났는데 새로운 과제가 들어온다면 한만큼 빼고 현재 과제를 스택에 넣는다.
                    int remainTime = cur.playtime - (nxt.start - curTime);
                    stopList.push(new Plan(cur.name, cur.start, remainTime));
                }
            } else {
                //남은 과제가 없다면 멈춘 과제들 시작
                if (stopList.isEmpty()) {
                    //멈춘 과제도 없다면 현재 과제를 하고 다음으로.
                    answer[idx++] = cur.name;
                    curTime += cur.playtime;
                } else {
                    answer[idx++] = cur.name;
                    while (!stopList.isEmpty()) {
                        Plan remain = stopList.pop();
                        answer[idx++] = remain.name;
                    }
                }
            }
        }

        return answer;
    }

    static class Plan implements Comparable<Plan> {

        String name;
        int start, playtime;

        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Plan p) {
            return this.start - p.start;
        }
    }
}
