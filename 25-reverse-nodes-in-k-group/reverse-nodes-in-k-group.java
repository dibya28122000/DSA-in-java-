class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (hasKNodes(prevGroupEnd.next, k)) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = groupStart;

            for (int i = 0; i < k; i++) {
                nextGroupStart = nextGroupStart.next;
            }

            ListNode newGroupStart = reverse(groupStart, k);

            prevGroupEnd.next = newGroupStart;
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private boolean hasKNodes(ListNode node, int k) {
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        return count == k;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        return prev;
    }
}