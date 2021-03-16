import java.util.Stack;

public class Solution227
{
    public int calculate(String s)
    {
        return evaluateExpression(s);
    }

    private static int evaluateExpression(String s)
    {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        //以空格为隔断符分割字符串
        s = s.trim();

        if(s.charAt(0) == '-')
            s = "0" + s;

        for (int i = 0; i < s.length(); i++)
        {
            //读取一个字符
            char c = s.charAt(i);
            if(c == ' ')
                continue;

            if(c == '-' || c == '+')
            {
                if(operators.isEmpty())
                    operators.push(c);
                else
                {
                    while(!operators.isEmpty())
                    {
                        calcValue(operators, operands);
                    }
                    operators.push(c);
                }
            }
            else if(c == '*' || c == '/')
            {
                if(operators.isEmpty() || operators.peek() == '+' || operators.peek() == '-')
                    operators.push(c);
                else
                {
                    /** 这种判断条件错误，切记切记！！！！！！！！！ */
                    //while(!operators.isEmpty() && (operators.peek() == '+' || operators.peek() != '-'))
                    while(!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/'))
                        calcValue(operators, operands);
                    operators.push(c);
                }
            }
            else
            {
                int num = 0;
                int k = i;
                while(k < s.length() && Character.isDigit(s.charAt(k)))
                {
                    num = num * 10 + s.charAt(k) - '0';
                    k++;
                }
                operands.push(num);
                i = k - 1;
            }
        }
        while (!operators.isEmpty())
        {
            calcValue(operators, operands);
        }

        return operands.pop();
    }

    private static void calcValue(Stack<Character> operators, Stack<Integer> operands)
    {
        char operator = operators.pop();
        int op2 = operands.pop();
        int op1 = operands.pop();
        if (operator == '+')
            operands.push(op1 + op2);
        else if(operator == '-')
            operands.push(op1 - op2);
        else if(operator == '*')
            operands.push(op1 * op2);
        else
            operands.push(op1 / op2);
    }

    public static void main(String[] args)
    {
        //String s= "1 + 1";
        //String s = "-1 + 1";
        //String s = " 2-1 + 2 ";
        //String s = "(1+(4+5+2)-3)+(6+8)";
        //String s = "1-(+1+1)";

        //String s = "3+2*2";
        //String s = "3/2";
        //String s = "3+5/2";
        String s = "1+2*5/3+6/4*2";
        System.out.println(evaluateExpression(s));
    }
}
