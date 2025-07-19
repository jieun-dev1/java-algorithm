package leetcode;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, getGcd(str1, str2));
    }

    public int getGcd(String str1, String str2) {
        int a = str1.length();
        int b = str2.length();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
