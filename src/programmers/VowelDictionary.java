package programmers;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
    static List<String> words = new ArrayList<>();
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        //Returns the index of the first occurrence of the specified element in this list,
        dfs("", 0);
        //because word will be unique.
        return words.indexOf(word) + 1;
    }

    public void dfs(String cur, int depth) {
        if (depth > 5) return;
        if (!cur.isEmpty()) {
            words.add(cur);
        }
        for (char c : vowels) {
            dfs(cur + c, depth + 1);
        }
    }
}
