import java.util.HashMap;

public class Solution115
{
    private static int count;
    private static HashMap<String, Integer> map = new HashMap<>();

    public int numDistinct1(String s, String t)
    {
        if(s == null || t == null || s.length() < t.length())
            return 0;

        count = 0;
        backtracking(s, t, 0, 0);
        return count;
    }

    public static void backtracking(String s, String t, int sIndex, int tIndex)
    {
        if(t.length() - tIndex > s.length() - sIndex)
            return;

        if(tIndex == t.length())
        {
            count++;
            return;
        }

        /*String key = sIndex + "&" + tIndex;
        if(map.containsKey(key))
        {
            count += map.get(key);
            return;
        }

        int count_pre = count;*/

        for (int i = sIndex; i < s.length() - t.length() + 1 + tIndex; i++)
        {
            if(s.charAt(i) == t.charAt(tIndex))
                backtracking(s, t, i + 1, tIndex + 1);
        }

    }

    public static int numDistinct(String s, String t)
    {
        int m = s.length(), n = t.length();
        if(m < n)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][n] = 1;

        for (int i = m - 1; i >= 0; i--)
        {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--)
            {
                char tChar = t.charAt(j);
                if(sChar == tChar)
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args)
    {
        count = 0;
        //String s = "rabbbit", t = "rabbit";
        //String s = "babgbag", t = "bag";
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        //backtracking(s, t, 0, 0);
        //System.out.println(count);
        System.out.println(numDistinct(s,t));
    };
}
