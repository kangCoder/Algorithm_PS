package simulation;

import java.util.*;

public class pro_소수찾기_lv2 {

    private Set<Integer> set = new HashSet<>();
    private boolean[] visited;

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void solve(int length, String tmp, String numbers) {
        if (tmp.length() == length) {
            set.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp += numbers.charAt(i);
                solve(length, tmp, numbers);
                visited[i] = false;

                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];

        int size = numbers.length();
        for (int i = 1; i <= size; i++) {
            solve(i, "", numbers);
        }

        for (Integer n : set) {
            if (isPrime(n)) {
                answer++;
            }
        }

        return answer;
    }
}
