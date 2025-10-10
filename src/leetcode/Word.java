//package leetcode;
//
//public String mergeAlternately(String word1, String word2) {
//    int minLen = Math.min(word1.length(), word2.length); //2
//    int maxLen = Math.max(word1.length, word2.length); //4
//    StringBuilder sb = new StringBuilder();
//    for (int i=0; i<minLen; i++) {
//        sb.append(word1.charAt(i));
//        sb.append(word2.charAt(i));
//    }
//    sb.append(word1.substring(minLen, Math.min(word1.length(), maxLen))).append(word2.substring(minLen, Math.min(word2.length, maxLen)));
//}