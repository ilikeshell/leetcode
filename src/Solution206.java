
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution206
{
    private ListNode newHead;

    public ListNode reverseList(ListNode head)
    {
        ListNode next = head, prev = null;
        while(next != null)
        {
            next = next.next; //指向剩余的链表
            head.next = prev; //与后面的链表切断
            prev = head;
            head = next;
        }

        return prev;
    }

    public void reverse(ListNode head, ListNode prev)
    {
        ListNode next = null;
        if(head == null)
        {
            newHead = prev;
            return;
        }
        else
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            reverse(head, prev);
        }
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        ListNode prev = null;

        new Solution206().reverse(head, prev);
    }
}
