//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 741 👎 0


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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;

        ListNode prev = null;       //left -> right 链表头
        ListNode tail;       //left -> right 链表尾

        ListNode nextNode;
        ListNode last;

        ListNode start = head;

        /** 第一段链表存在或者不存在 */
        if(left == 1)
            last = null;
        else
        {
            for(int i = 2; i < left; i++)
                start = start.next;

            last = start;   //定位第m-1个节点
            start = start.next;   //start指向第m个节点
        }


        tail = start;   //第m个节点将变成尾节点

        while(left <= right)
        {
            nextNode = start.next;
            start.next = prev;
            prev = start;
            start = nextNode;
            left++;
        }

        tail.next = start;

        if(last != null)
            last.next = prev;
        else
        {
            head = prev;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)