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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //申请一个哑节点，方便找到头结点
        ListNode dummyP = new ListNode(0, null);
        //当前节点
        ListNode currP = dummyP;
        //保存进位
        int c = 0;

        //只要还有一个链表还存在节点
        while(l1 != null || l2 != null)
        {
            //用于保存每个节点的和， sum = l1.val + l2.val + c
            //c保存了上一对节点的加法进位
            int sum = 0;

            //小技巧，分别计算，即使两个链表不一样长
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            //不要忘记进位
            sum += c;

            //保存进位
            c = sum / 10;
            //取余
            sum = sum % 10;

            //申请新的节点，并挂载到前一节点
            currP.next = new ListNode(sum, null);
            currP = currP.next;
        }

        //如果最后还有进位，需再申请一个节点
        if(c != 0)
        {
            currP.next = new ListNode(c, null);
            currP = currP.next;
        }
        return dummyP.next;
    }
}