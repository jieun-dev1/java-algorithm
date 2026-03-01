package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

class ValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int closedCnt = 0;
        int openCnt = 0;

        //close > open 일때는,
        //close 를 제거한다.
        //그래서 앞의 2개를 제거함..
        //Open count 가 2인데, 끝날때까지 open> close 라면,
        //open-close 만큼 제거.
        //open 과 close 의 위치.. 적어두기

        List<Integer> deleteOrders = new ArrayList<>();
        List<Integer> openOrders = new ArrayList<>();

        for (int i=0;i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (closedCnt >= openCnt) {
                    deleteOrders.add(i);
                } else {
                    openOrders.removeLast();
                    closedCnt ++;
                }
            }
            if (c == '(') {
                openCnt ++;
                openOrders.add(i);
            }
        }
        if (openCnt > closedCnt) {
            int cnt = openCnt - closedCnt;
            for (int i=0; i<cnt; i++) {
                deleteOrders.add(openOrders.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (!deleteOrders.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
