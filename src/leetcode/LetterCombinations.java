package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    List<String> answers = new ArrayList<>();
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        //int[] nums = digits.chars().map(c -> c - '0').toArray();
        dfs(0, new StringBuilder(), digits);
        return answers;
    }

    //char -> int num =  char - '0'
    public void dfs(int currentIndex, StringBuilder current, String digits) {

        if (currentIndex == digits.length()) {
            answers.add(current.toString());
            return;
        }
        int num = digits.charAt(currentIndex)-'0';
        //int num = digitNums[currentIndex];
        for (int i=0; i<letters[num].length(); i++) {
            dfs(currentIndex + 1, current.append(letters[num].charAt(i)), digits);
            current.deleteCharAt(current.length()-1); //without this the change will be remained like ad, ade, adef...
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> answers = letterCombinations.letterCombinations("23");
        for (String answer: answers) {
            System.out.println(answer);
        }
    }
}
