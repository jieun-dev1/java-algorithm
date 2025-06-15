package leetcode;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    List<String> answers = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0, n, 0, 0, "");
        return answers;
    }

    public void dfs(int index, int n, int openingCount, int sum, String current) {
        if (index == n*2) {
            answers.add(current.toString());
            return;
        }
        if (sum == 0) {
            if (openingCount < n) {
                dfs(index + 1, n, openingCount + 1, sum + 1, current + "(") ;
            } else {
                return;
            }
        }
        if (sum >= 1) {
            if (openingCount < n) {
                dfs(index + 1, n, openingCount + 1, sum + 1, current + "(");
                dfs(index + 1, n, openingCount, sum - 1, current + ")");
            } else {
                dfs(index + 1, n, openingCount, sum - 1, current + ")");
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(1));
    }
}



