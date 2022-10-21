package addTwoNumbers;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static void main(String [] args){

//        ListNode l1 = new ListNode();
//        l1.val = 9;
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode();
//        l2.val = 9;
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

        ListNode l1 = new ListNode();
        l1.val = 2;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode();
        l2.val = 5;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        ListNode l1 = new ListNode();
//        l1.val = 3;
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(0);
//        l1.next.next.next = new ListNode(0);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(0);
//        l1.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next = new ListNode(6);
//        l1.next.next.next.next.next.next.next.next.next = new ListNode(1);
//
//        ListNode l2 = new ListNode();
//        l2.val = 5;
//        l2.next = new ListNode(5);
//        l2.next.next = new ListNode(8);
//        l2.next.next.next = new ListNode(6);
//        l2.next.next.next.next = new ListNode(2);
//        l2.next.next.next.next.next = new ListNode(5);
//        l2.next.next.next.next.next.next = new ListNode(8);
//        l2.next.next.next.next.next.next.next = new ListNode(2);
//        l2.next.next.next.next.next.next.next.next = new ListNode(6);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(1);


        ListNode ln = addTwoNumbers3(l1, l2);
        while (ln != null){
            System.out.println(ln.val);
            ln = ln.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        while (l1 != null){
            num1 = l1.val + num1;
            l1 = l1.next;
        }

        String num2 = "";
        while (l2 != null){
            num2 = l2.val + num2;
            l2 = l2.next;
        }

        String result = (new BigInteger(num1).add(new BigInteger(num2))) + "";

        ListNode ln = new ListNode();
        for (int length = 0; length < result.length(); length++) {
            ln.val = Integer.parseInt(result.charAt(length) + "");
            ListNode l = new ListNode();

            l.next = ln;
            if(length != result.length() - 1){
                ln = l;
            }

        }

        return ln;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ArrayList<Integer> list = new ArrayList<>();
        int remainder = 0;
        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int res = l1.val + l2.val + remainder;
                if(res > 10){
                    remainder = res % (res - 1);
                    list.add(res - 10);
                }else{
                    if(res >= 10){
                        list.add(res - 10);
                        remainder = res % (res - 1);
                    }else{
                        list.add(res);
                        remainder = 0;
                    }

                }
                l1 = l1.next;
                l2 = l2.next;

            }else if(l1 != null && l2 == null){
                if(l1.val + remainder >= 10){
                    list.add(l1.val - 10 + remainder);
                    remainder = l1.val % (l1.val - 1);
                }else{
                    list.add(l1.val + remainder);
                    remainder = 0;
                }
                l1 = l1.next;
            }else if(l1 == null && l2 != null){
                if(l2.val + remainder >= 10){
                    list.add(l2.val - 10 + remainder);
                    remainder = l2.val % (l2.val - 1);
                }else{
                    list.add(l2.val + remainder);
                    remainder = 0;
                }
                l2 = l2.next;
            }

        }

        if(remainder != 0){
            list.add(remainder);
        }

        ListNode ln = new ListNode();
        for (int length = list.size() - 1; length >= 0; length--) {
            ln.val = list.get(length);
            ListNode l = new ListNode();

            l.next = ln;
            if(length != 0){
                ln = l;
            }

        }

        return ln;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode();
        ListNode ln1 = ln;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder == 1){
            int res = 0;
            if(l1 != null){
                res += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                res += l2.val;
                l2 = l2.next;
            }

            res += remainder;
            remainder = res / 10;

            ListNode l = new ListNode();
            l.val = res % 10;
            ln1.next = l;
            ln1 = ln1.next;
        }

        return ln.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
