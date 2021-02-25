public class Solution52
{
    private int[] queens;
    private int count;

    public void nQueens(int n)
    {
        queens = new int[n];
        for (int i = 0; i < n; i++)
        {
            queens[i] = -1;
        }

        search(0);
    }

    private void search(int row)
    {
        if(row == queens.length)
        {
            count++;
            return;
        }

        for (int i = 0; i < queens.length; i++)
        {
            if(!isValidPos(row, i))
                continue;
            queens[row] = i;
            search(row+1);
            queens[row] = -1;
        }
    }

    private boolean isValidPos(int row, int column)
    {
        for (int i = 1; i <= row; i++)
        {
            if(queens[row - i] == column ||
                    queens[row - i] == column + i ||
                    queens[row - i] == column - i)
                return false;
        }
        return true;
    }
    public int totalNQueens(int n)
    {
        nQueens(n);
        return count;
    }
}
