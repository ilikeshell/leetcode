public class Solution61
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null || k < 0)
            return null;

        int len = 1;
        ListNode moveP = head, tailP;

        while (moveP.next != null)
        {
            moveP = moveP.next;
            len++;
        }

        tailP = moveP;
        moveP = head;

        k = len - (k % len);

        while(k > 1)
        {
            moveP = moveP.next;
            k--;
        }

        tailP.next = head;
        head = moveP.next;
        moveP.next = null;

        return head;
    }
}
