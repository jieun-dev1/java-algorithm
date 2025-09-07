import java.util.HashMap;

public class LongestSubstringWithKDistinct {

    public int solution(int k, String s) {

        int left = 0;
        int right = 0;
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>(); //Char 랑, Char 등장 횟수.

        while (left <= right && right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove((s.charAt(left)));
                }
                left += 1;
            } else {
                answer = Math.max(answer, right - left + 1);
                right += 1; //여기서 한다면, abc 같은 케이스가 위에서 걸리면, 다음에서 불필요하게, Bc 를 확인해야 함.
            }
            right += 1;
        }


        return answer;
    }

    public static void main(String[] args) {
        LongestSubstringWithKDistinct kDistinct = new LongestSubstringWithKDistinct();
        System.out.println(kDistinct.solution(2, "eceba"));
        System.out.println(kDistinct.solution(2, "abcd"));


    }
}
