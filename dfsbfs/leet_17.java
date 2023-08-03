package dfsbfs;

import java.util.*;

public class leet_17 {

    static List<String> ans;
    static String[] letters = {
            "", "", "abc",
            "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

    private void backTracking(int cur, StringBuilder letter, String digits) {
        if (cur == digits.length()) {
            ans.add(letter.toString());
            return;
        }

        int num = Character.getNumericValue(digits.charAt(cur));
        for (int i = 0; i < letters[num].length(); i++) {
            letter.append(letters[num].charAt(i));
            backTracking(cur + 1, letter, digits);
            letter.setLength(letter.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }

        StringBuilder letter = new StringBuilder();
        backTracking(0, letter, digits);
        return ans;
    }

}
