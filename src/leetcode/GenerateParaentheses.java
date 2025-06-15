package leetcode;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    List<String> answers = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, n, 0, 0, new StringBuilder(""));
        return answers;
    }

    public void dfs(int index, int n, int openingCount, int sum, StringBuilder current) {
        if (index == n*2) {
            answers.add(current.toString());
            return;
        }
        if (sum == 0) {
            if (openingCount < 3) {
                dfs(index + 1, n, openingCount + 1, sum + 1, current.append("("));
            } else {
                return;
            }
        }
        if (sum >= 1) {
            if (openingCount < 3) {
                dfs(index + 1, n, openingCount + 1, sum + 1, current.append("("));
                dfs(index + 1, n, openingCount, sum - 1, current.append(")"));
            } else {
                dfs(index + 1, n, openingCount, sum - 1, current.append(")"));
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        gp.generateParenthesis(3);
    }
}



