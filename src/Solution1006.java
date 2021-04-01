import java.util.Stack;

public class Solution1006
{
    public static void main(String[] args)
    {
        System.out.println(clumsy(10));
    }
    public static int clumsy(int N)
    {
        if(N <= 0)
            return 0;

        int res = 0;
        int item;

        //先处理N大于4的情况，每处理一次，N递减4
        if(N >= 4)
        {
            //一次处理4个数字
            res = N * (N - 1) / (N - 2) + (N - 3);
            N = N - 4;

            while (N >= 4)
            {
                //继续处理4个数字，注意加号变成减号
                item = N * (N - 1) / (N - 2) - (N - 3);

                res = res - item;

                N = N - 4;
            }
        }

        //再处理小于等于3的情况
        if(N == 3)
            item = N * (N - 1) / (N - 2);
        else if(N == 2)
            item = N * (N - 1);
        else
            item = N;

        if(res > 0)
            res = res - item;
        else
            res = item;

        return res;
    }


    /** 用栈的方法实现，但速度较慢 */
    public int clumsy1(int N)
    {
        int op = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(N);

        for (int i = N - 1; i > 0; i--)
        {
            if(op == 0)
                stack.push(stack.pop() * i);
            else if(op == 1)
                stack.push(stack.pop() / i);
            else if(op == 2)
                stack.push(i);
            else if(op == 3)
                stack.push(-i);

            op = (op + 1) % 4;
        }

        int res = 0;
        while(!stack.isEmpty())
            res += stack.pop();

        return res;
    }
}
