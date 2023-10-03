package backtracking;

import java.util.*;

public class pro_모음사전 {

    private char[] words = {'A', 'E', 'I', 'O', 'U'};
    private List<String> list = new ArrayList<>(); //중복순열로 만들어진 단어를 저장하는 리스트

    private void dfs(String word, int len) {
        //길이가 5 이상인 단어는 만들 필요가 없다.
        if (len > 5) {
            return;
        }

        //바로바로 만들어진거 넣어주기
        list.add(word);

        for (int i = 0; i < 5; i++) {
            dfs(word + words[i], len + 1);
        }
    }

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}
