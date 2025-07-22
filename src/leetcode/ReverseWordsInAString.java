package leetcode;

import java.util.Arrays;

class ReverseWordsInAString {
    char[] chars;

    public String reverseWords(String s) {
        chars = s.trim().toCharArray();
        int len = chars.length;
        //as it is 0 based index, right should be len -1
        reverse(0, len-1);

        //reverse by words (ignoring the spaces)
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                start ++;
                continue;
            }
            if (i == len - 1 || chars[i + 1] == ' ') {
                reverse(start, i);
                start = i+1;
            }
        }

        int readCount = 0;
        int writeCount = 0;

        while (readCount < len) {
            // with readCount < len, I don't need to check if readCount >= n in the while block
            // writeCount increases with readCount, don't need to check writeCount's range
            while (readCount < len && chars[readCount] != ' ') {
                chars[writeCount++] = chars[readCount++];
            }

            // 공백 하나만 유지
            // with this, keep reading, but only write one space.
            while (readCount < len && chars[readCount] == ' ') readCount++;
            //as the range is within, if the last is space, it won't be recorded.
            if (readCount < len) {
                chars[writeCount++] = ' ';
            }

            //wrong code
        //  while (readCount < len && chars[readCount - 1] == ' ' && chars[readCount] == ' ') {
//               readCount++;
//               if (readCount >= len) break;
        }

        return new String(chars, 0, writeCount);
    }

    public void reverse(int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }
    public static void main(String[] args) {
        ReverseWordsInAString rws = new ReverseWordsInAString();
        //System.out.println(rws.reverseWords("the sky is blue"));
        System.out.println(rws.reverseWords("a good   example"));
    }
}
