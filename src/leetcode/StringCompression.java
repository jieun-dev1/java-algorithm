package leetcode;

import java.util.HashMap;
import java.util.Map;

class StringCompression {
        public int compress(char[] chars) {
            int length = chars.length;
            Map<Character, Integer> group = new HashMap<>();
            char currentChar = '0';
            char previousChar = '0';
            int writeCount =0;

            for (int i=0; i< length; i++) {
                if (length == 1){
                    return 1;
                }
                currentChar = chars[i];
                if (currentChar!=previousChar) {
                    //prevent null point exception
                    if (group.get(previousChar)!=null && group.get(previousChar) > 1) {
                        String cntStr = String.valueOf(group.get(previousChar));
                        int cnt = String.valueOf(group.get(previousChar)).length();
                        int j = 0;
                        while(j<cnt){
                            chars[writeCount] = cntStr.charAt(j);
                            j+=1;
                            writeCount += 1;
                        }
                        group.remove(previousChar);
                    }
                    //if first char, just put the currentChar.
                    chars[writeCount] = currentChar;
                    previousChar = currentChar;
                    writeCount += 1;
                } else  {
                   group.put(previousChar, group.getOrDefault(previousChar, 1)+1);
                   //if last ends with ccc.. (which has more than 2 consecutive, ) it might be missed.
                    if (i == length-1) {
                        String cntStr = String.valueOf(group.get(previousChar));
                        int cnt = String.valueOf(group.get(previousChar)).length();
                        int j = 0;
                        while(j<cnt){
                            chars[writeCount] = cntStr.charAt(j);
                            j+=1;
                            writeCount += 1;
                        }
                        group.remove(previousChar);
                    }
                }
            }
            return writeCount;
        }

        public void removeKeyAndAddCount(){

        }

        public static void main(String[] args) {
            StringCompression sc = new StringCompression();
            System.out.println(sc.compress(new char[]{'a','a','b','b','c','c','c'}));
            System.out.println(sc.compress(new char[]{'a', 'b', 'b', 'b', 'b','b', 'b','b','b'}));
            System.out.println(sc.compress(new char[]{'a'}));

        }
}
