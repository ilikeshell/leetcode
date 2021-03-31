import java.util.Arrays;

public class Solution74
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix == null)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if(m == 0 || n ==0)
            return false;

        int rLeft = 0, rRight = m - 1, rMiddle = (rLeft + rRight) / 2;

        while (rLeft <= rRight)
        {
            rMiddle  = (rLeft + rRight) / 2;
            if(matrix[rMiddle][0] == target)
                return true;
            else if (target > matrix[rMiddle][0])
                rLeft = rMiddle + 1;
            else
                rRight = rMiddle - 1;
        }

        if(rRight < 0)
            return false;

        int index;

        if(rLeft > rMiddle)
            index = Arrays.binarySearch(matrix[rMiddle], target);
        else
            index = Arrays.binarySearch(matrix[rRight], target);



        return index >= 0 ? true : false;
    }
}
