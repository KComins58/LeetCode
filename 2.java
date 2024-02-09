public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lHead = new ListNode(0);
        ListNode iCur = lHead;
        int iCar = 0;

        while (l1 != null || l2 != null || iCar != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int iSum = x + y + iCar;
            iCar = iSum / 10;

            iCur.next = new ListNode(iSum % 10);
            iCur = iCur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return lHead.next;
    }
}
