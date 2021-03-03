public class Solution304
{
    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5},
                };

        System.out.println(new NumMatrix(matrix).sumRegion(2,1,4,3));
    }
}

class NumMatrix {
    private int[][] SumMatrix;
    public NumMatrix(int[][] matrix)
    {
        if(matrix.length > 0)
        {
            SumMatrix = new int[matrix.length][matrix[0].length];
        }

        for (int i = 0; i < matrix.length; i++)
        {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++)
            {
                sum += matrix[i][j];
                SumMatrix[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int sum = 0;

        for (int i = row1; i <= row2; i++)
        {
            int start = (col1 == 0) ? 0 : SumMatrix[i][col1-1];
            sum += SumMatrix[i][col2] - start;
        }

        return sum;
    }
}
