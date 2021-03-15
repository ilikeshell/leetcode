import java.util.ArrayList;
import java.util.List;

public class Solution54
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution54 s = new Solution54();

        List<Integer> ret = s.spiralOrder1(matrix);

        for(int e : ret)
            System.out.print(e + " ");

    }
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ret = new ArrayList<>();
        spiralOrder(matrix, ret);
        return ret;
    }

    public void spiralOrder(int[][] matrix, List<Integer> ret)
    {
        int m1 = 0, m2 = matrix.length - 1;
        int n1 = 0, n2 = matrix[0].length - 1;

        int number = matrix.length * matrix[0].length;

        while (true)
        {
            if(ret.size() >= number) break;
            for (int i = m1, j = n1; j <= n2 ; j++)
            {
                ret.add(matrix[i][j]);

            }
            m1++;

            if(ret.size() >= number) break;
            for (int i = m1, j = n2; i <= m2; i++)
            {
                ret.add(matrix[i][j]);

            }
            n2--;

            if(ret.size() >= number) break;
            for (int i = m2, j = n2; j >= n1; j--)
            {
                ret.add(matrix[i][j]);

            }
            m2--;

            if(ret.size() >= number) break;
            for (int i = m2, j = n1; i >= m1; i--)
            {
                ret.add(matrix[i][j]);

            }
            n1++;

        }
    }

    public List<Integer> spiralOrder1(int[][] matrix)
    {
        int m1 = 0, m2 = matrix.length - 1;
        int n1 = 0, n2 = matrix[0].length - 1;
        List<Integer> ret = new ArrayList<>();
        int number = matrix.length * matrix[0].length;

        /** 如何优雅的确定循环终止？？？？？？？ */
        while (ret.size() < number)
        {
            for (int i = m1, j = n1; j <= n2 ; j++)
                ret.add(matrix[i][j]);
            /** 这种判断没有用 */
            if(ret.size() < number) m1++;


            for (int i = m1, j = n2; i <= m2; i++)
                ret.add(matrix[i][j]);
            /** 这种判断没有用 */
            if(ret.size() < number) n2--;

            for (int i = m2, j = n2; j >= n1; j--)
                ret.add(matrix[i][j]);
            /** 这种判断没有用 */
            if(ret.size() < number) m2--;

            for (int i = m2, j = n1; i >= m1; i--)
                ret.add(matrix[i][j]);
            /** 这种判断没有用 */
            if(ret.size() < number) n1++;

        }
        return ret;
    }

}
