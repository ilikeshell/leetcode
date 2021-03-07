import java.util.ArrayList;
import java.util.List;

public class Solution131
{
    private List<List<String>> ret = new ArrayList<>();
    private ArrayList<String> path = new ArrayList<>();

    public List<List<String>> partition(String s)
    {
        backtracking(s, 0);
        return ret;
    }

    private void backtracking(String s, int startIndex)
    {
        if(startIndex >= s.length())
        {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++)
        {
            if(isPalindrome(s,startIndex,i))
            {
                String str = s.substring(startIndex, i + 1);
              //  System.out.println(str);
                path.add(new String(str));
            }
            else
                continue;
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end)
    {
        for (int i = start, j = end; i < j; i++, j--)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution131 s = new Solution131();
        String str = "aab";
        System.out.println(s.partition(str).size());
    }
}
