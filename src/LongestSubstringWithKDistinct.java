import java.util.HashMap;
import java.util.Map;

//variable size window
public class LongestSubstringWithKDistinct {

    public int solution(int k, String s) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }
        int left = 0;
        int answer = 0;

        Map<Character, Integer> charCount = new HashMap<>(); //Char 등장 횟수 - 문자 개수, 요소 빈도 추적

        for (int right = 0; right < s.length(); right ++) {
            //1.현재 문자를 윈도우에 포함
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            //2. 윈도우 축소
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                //Once it reached 0, get rid of it from the map
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left ++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDistinct kDistinct = new LongestSubstringWithKDistinct();
        System.out.println(kDistinct.solution(2, "eceba"));
        System.out.println(kDistinct.solution(2, "abcd"));


    }
}
