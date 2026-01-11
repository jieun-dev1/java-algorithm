package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidAnagram {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();

            for (int i=0; i<s.length(); i++) {
                list1.add(s.charAt(i));
            }
            for (int j=0; j<t.length(); j++) {
                list2.add(t.charAt(j));
            }
            Collections.sort(list1);
            Collections.sort(list2);

            return list1.equals(list2);
        }
}
