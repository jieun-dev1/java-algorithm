package leetcode.string;

class CountSubstrings {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int cur = 1;
        int answer = 0;
        for (int i = 1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur ++;
            } else {
                answer += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        return answer + Math.min(prev, cur);
    }}
