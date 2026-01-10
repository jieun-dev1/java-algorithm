package leetcode;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //각 자리의 숫자를 더하고, 10을 넘으면 다음 자리로 옮긴다.
        //자리수가 일치하지 않는다면, 없는 자리에 0을 넣는다.

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0; // 10을 넘을 때.

        while(l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}