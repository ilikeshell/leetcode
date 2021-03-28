//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 509 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution82 {
    /**  方法1: 不使用哑节点 */
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
            return null;

        /** 定义三个指针 */
        ListNode prevP = null, currP = head, lastP;

        /** 如果开头有重复元素 */
        while(head != null && head.next != null && head.val == head.next.val)
        {
            currP = head.next;

            while(currP != null && head.val == currP.val)
            {
                currP = currP.next;
            }
            head = currP;
        }


        /* 如果有下一个节点 */
        while(currP != null && currP.next != null)
        {
            /** 如果当前节点的值和下一个节点的值不相同 */
            if(currP.val != currP.next.val)
            {
                prevP = currP;
                currP = currP.next;
            }
            else {
                /** 寻找剩余值相同的节点 */
                while(currP.next != null && currP.val == currP.next.val)
                    currP = currP.next;

                lastP = currP;
                currP = currP.next;

                prevP.next = lastP.next;
                lastP.next = null;
            }
        }
        return head;
    }

    /**  方法2: 使用哑节点 */
    public ListNode deleteDuplicates2(ListNode head)
    {
        if (head == null)
            return null;

        ListNode dummyP = new ListNode(0, head);
        ListNode curP = dummyP;
        ListNode moveP;

        while(curP.next != null && curP.next.next != null)
        {
            if(curP.next.val == curP.next.next.val)
            {
                moveP = curP.next;
                while(moveP.next != null && moveP.val == moveP.next.val)
                    moveP = moveP.next;
                curP.next = moveP.next;
            }
            else
                curP = curP.next;
        }

        return dummyP.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
