package leetcode;

import java.util.HashMap;
import java.util.Map;

class StringCompression {
    Map<Character, Integer> group = new HashMap<>();

    public int compress(char[] chars) {

        int write = 0;
        int anchor = 0; //where new group stsarts
        for (int read = 0; read <= chars.length - 2; read++) {
            if (read == chars.length-1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int count = read - anchor + 1; //count should be the method variable. unless should renew after the below func

                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

        public static void main(String[] args) {
            StringCompression sc = new StringCompression();
            System.out.println(sc.compress(new char[]{'a','a','b','b','c','c','c'}));
            System.out.println(sc.compress(new char[]{'a', 'b', 'b', 'b', 'b','b', 'b','b','b'}));
            System.out.println(sc.compress(new char[]{'a'}));

        }
}
