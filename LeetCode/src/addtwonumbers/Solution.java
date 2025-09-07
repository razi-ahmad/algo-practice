package addtwonumbers;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        var test1 = new Solution().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        );
        while (test1 != null) {
            System.out.print(test1.val + " ");
            test1 = test1.next;
        }
        System.out.println();
        var test2 = new Solution().addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        );
        while (test2 != null) {
            System.out.print(test2.val + " ");
            test2 = test2.next;
        }

        var test3 = new Solution().addTwoNumbers(
               new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))),
               new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))
        );
        while (test3 != null) {
            System.out.print(test3.val + " ");
            test3 = test3.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";

        while (l1 != null) {
            s1 = l1.val + s1;
            l1 = l1.next;
        }


        while (l2 != null) {
            s2 = l2.val + s2;
            l2 = l2.next;
        }

        var total = new BigInteger(s1).add(new BigInteger(s2));
        var s3 = String.valueOf(total).toCharArray();

        ListNode head = new ListNode(Character.getNumericValue(s3[s3.length - 1])), curr = head;
        for (int i = s3.length - 2; i >= 0; i--) {
            curr.next = new ListNode(Character.getNumericValue(s3[i]));
            curr = curr.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}