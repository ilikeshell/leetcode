import java.util.LinkedList;
import java.util.Queue;

public class Solution232
{
    public static void main(String[] args)
    {
        /**
         * Your MyQueue object will be instantiated and called as such:
         * MyQueue obj = new MyQueue();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.peek();
         * boolean param_4 = obj.empty();
         */
    }
}

class MyQueue
{
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return queue.isEmpty();
    }
}

