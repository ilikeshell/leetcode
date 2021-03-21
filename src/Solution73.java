public class Solution73
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                    rows[i] = cols[j] = true;
            }
        }


        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(rows[i]|| cols[j])
                    matrix[i][j] = 0;
    }
}
