package leetcode;

import java.util.*;

public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Integer> locations = new ArrayList<>();
        List<Character> values = new ArrayList<>();
        for (int i=0; i<chars.length; i++){
            if (vowels.contains(Character.toLowerCase(chars[i]))) {
                locations.add(i);
                values.add(chars[i]);
            }
        }
        System.out.println(locations.size());
        for (int i=0; i<locations.size(); i++) {
           chars[locations.get(i)] = values.get(locations.size()-1 - i);
        }
        return new String(chars); //Arrays.toString(chars);
    }

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels("IceCreAm"));
    }
}
