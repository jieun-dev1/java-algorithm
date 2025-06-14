package leetcode;

import java.util.*;

/**
 * HashSet 은 순서 보장 하지 안는다. queue 에서 원소 뽑을 때마다, String 을 새로 만들어줘야 한다.
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        Map<String, Integer> vowelOrder = new HashMap<>();
        //assign order into each character
        for (int i = 0; i < vowels.length; i++) {
            vowelOrder.put(vowels[i], i);
        }
        Queue<String> queue = new LinkedList<>();
        List<String> answer = new ArrayList<>();

        for (String vowel : vowels) {
            queue.offer(vowel);
        }
        //StringBuilder 장점
        if (n == 1) {
            return 5;
        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            String key = String.valueOf(temp.charAt(temp.length() - 1)); //  String -> char -> String
            int lastLetterOrder = vowelOrder.get(key);
            for (int i = 0; i < vowels.length; i++) {
                if (lastLetterOrder <= i) {
                    String newSt = temp + vowels[i];
                    if (newSt.length() == n) {
                        answer.add(newSt);
                    } else {
                        queue.offer(newSt);
                    }
                }
            }
        }
        return answer.size();
    }

//    public int countVowelStrings(int n) {
//        Map<String, Boolean> visited = new HashMap<>();
//        String[] vowels = {"a", "e", "i", "o", "u"};
//        Map<String, Integer> vowelOrder = new HashMap<>();
//        //assign order into each character
//        for (int i = 0; i < vowels.length; i++) {
//            vowelOrder.put(vowels[i], i);
//        }
//        Set<String> answer = new HashSet<>();
//
//    }
    public static void main(String[] args) {
        CountSortedVowelStrings st = new CountSortedVowelStrings();
        System.out.println(st.countVowelStrings(1));
    }
}


