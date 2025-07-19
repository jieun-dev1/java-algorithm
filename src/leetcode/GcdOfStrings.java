package leetcode;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        boolean result = sb.append(str1).append(str2).toString().contentEquals(sb2.append(str2).append(str1));
        if (!result) return "";

        int minSize = getGcd(str1, str2);

        int count = 0;
        String gcdString = str2.substring(0, minSize);
        while(count < str1.length()){
            if (!str1.startsWith(gcdString, count)) {
                return "";
            }
            count += gcdString.length();
        }
        while(count < str2.length()){
            if (!str2.startsWith(gcdString, count)) {
                return "";
            }
            count += gcdString.length();
        }
        return gcdString;
    }

    public int getGcd(String str1, String str2){
        int a = str1.length();
        int b = str2.length();
        while (b!=0) {
            //a 8 b 6
            int temp = b; //여기서 이전의 b 를 백업해준다.
            b = a % b; //b를 a 를 b로 나눈 나머지로 새롭게 할당. 이후 둘의 최대 공약수를 구하는 것.
            a = temp; //a 에 이전 b 할당. 마지막으로 나눈 최대 공약수가 temp 에 저장된다.
        }
        return a;
    }
}
