package leetcode;

import java.util.*;

public class DecodeWays {
    int answer = 0;
    Map<String, String> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");

        int left = 0;
        int right = 1;

        while (left < right) {
            dfs(left, right, s);
            if (right < s.length()){
                right += 1;
                dfs(left, right, s);
            }
            break;
        }
        return answer;
    }

    public void dfs(int start, int end, String s) {
        if (map.get(s.substring(start, end)) == null)
            return;
        if (end == s.length()) {
            if (map.get(s.substring(start, end)) != null) {
                answer += 1;
            }
        }
        if (end < s.length()) {
            dfs(end, end + 1, s);
        }
        if (end + 1 < s.length()) {
            dfs(end, end + 2, s);
        }
    }

    public static void main(String[] args){
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("226"));
        //System.out.println(dw.numDecodings("1"));

    }
}
