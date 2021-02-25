import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution51
{
    private int[] queens;
    private int count;
    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n)
    {
        nQueens(n);
        return results;
    }

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
            List<String> result = getRetString(queens);
            results.add(result);
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
    public int totalNQueens(int n) {
        nQueens(n);
        return count;
    }

    public List<String> getRetString(int[] queens)
    {
        List<String> list = new ArrayList<>();

        char[][] gragh = new char[queens.length][queens.length];
        for (int i = 0; i < queens.length; i++)
        {
            for (int j = 0; j < queens.length; j++)
            {
                gragh[i][j] = '.';
            }
        }

        for (int i = 0; i < queens.length; i++)
        {
            gragh[i][queens[i]] = 'Q';
            list.add(new String(gragh[i]));
        }


        return list;
    }

    public void printList(List<String> list)
    {
        System.out.print("[");
        int i;
        for (i = 0; i < list.size() - 1; i++)
        {
            System.out.print("\"" + list.get(i) + "\"" + ",");
        }
        System.out.print("\"" + list.get(i) + "\"");
        System.out.print("]");
    }

    public void printAllSolution( )
    {
        System.out.print("[");
        int i;
        for (i = 0; i < results.size() - 1; i++)
        {
            printList(results.get(i));
            System.out.print(",");
        }
        printList(results.get(i));
        System.out.print("]");
    }

    public static void main(String[] args)
    {

        Solution51 s = new Solution51();
        List<List<String>> results = s.solveNQueens(4);

        s.printAllSolution();
        //System.out.println("--------------");


/*        Solution s = new Solution();
        int[] test = {1,3,0,2};
        List<String> list = s.getRetString(test);
       // System.out.println(list);
        s.printList(list);*/
    }
}