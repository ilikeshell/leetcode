import java.util.HashMap;
import java.util.Map;

public class Solution781
{
    public static void main(String[] args)
    {
        int[] answers= {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(numRabbits(answers));
    }
    public static int numRabbits(int[] answers)
    {
        /** 合法性检查 */
        if(answers == null || answers.length == 0)
            return 0;

        /** key : 还有多少其他的兔子和自己有相同的颜色
         *  value : 相同颜色的兔子已经出现了多少只
         *  如果 value > key + 1, 则key表示另外
         *  一种颜色，但数量相同的兔子出现
         */
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < answers.length; i++)
        {
            if(!map.containsKey(answers[i]))
                map.put(answers[i], 1);
            else
            {
                int value = map.get(answers[i]);
                value++;
                if(value > answers[i] + 1)
                {
                    count += answers[i] + 1;
                    value = 1;
                }
                map.put(answers[i], value);
            }
        }

        for(Integer i : map.keySet())
        {
            count += i + 1;
        }

        return count;
    }
}
