class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    ListNode add(ListNode a, ListNode b, int carry) {
        if (a == null && b == null && carry == 0)
            return null;

        int sum = carry;

        if (a != null) sum += a.val;
        if (b != null) sum += b.val;

        ListNode ans = new ListNode(sum % 10);

        ans.next = add(
            a == null ? null : a.next,
            b == null ? null : b.next,
            sum / 10
        );

        return ans;
    }
}