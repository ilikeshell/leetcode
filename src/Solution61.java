public class Solution61
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head == null || k < 0)
            return null;

        int len = 1;
        ListNode moveP = head, tailP;

        /** 计算链表长度并保存尾节点 */
        while (moveP.next != null)
        {
            moveP = moveP.next;
            len++;
        }

        tailP = moveP;
        moveP = head;

        /** 找到倒数第K%len个元素，需找到前 len - (k % len) 个元素 */
        k = len - (k % len);

        /** 查找 */
        while(k > 1)
        {
            moveP = moveP.next;
            k--;
        }

        /** 修改指针指向 */
        tailP.next = head;
        head = moveP.next;
        moveP.next = null;

        /** 返回新的链表头 */
        return head;
    }
}
