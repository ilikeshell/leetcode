public class Solution59
{
    public int[][] generateMatrix(int n)
    {
        int m1 = 0, m2 = n - 1;
        int n1 = 0, n2 = n - 1;

        int[][] matrix = new int[n][n];

        int number = n * n;
        int count = 0;

        while (true)
        {
            if(count >= number) break;
            for (int i = m1, j = n1; j <= n2 ; j++)
            {
                matrix[i][j] = count;
                count++;
            }
            m1++;

            if(count >= number) break;
            for (int i = m1, j = n2; i <= m2; i++)
            {
                matrix[i][j] = count;
                count++;
            }
            n2--;

            if(count >= number) break;
            for (int i = m2, j = n2; j >= n1; j--)
            {
                matrix[i][j] = count;
                count++;
            }
            m2--;

            if(count >= number) break;
            for (int i = m2, j = n1; i >= m1; i--)
            {
                matrix[i][j] = count;
                count++;
            }
            n1++;
        }
        return matrix;
    }
}
