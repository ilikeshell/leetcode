import java.util.HashMap;
import java.util.Map;

public class Solution395
{
    public int longestSubstring(String s, int k)
    {
        if(s.length() < k)
            return 0;

        char[] chs = s.toCharArray();
        int[] chCnt = new int[26];
        for (int i = 0; i < chs.length; i++)
        {
            chCnt[chs[i] - 'a']++;
        }

        StringBuilder regex = new StringBuilder("[");
        for(char c : chs)
        {
            if(chCnt[c - 'a'] < k)
                regex.append(c);
        }
        regex.append(']');

        if(regex.length() > "[]".length())
        {
            int count = 0;
            for(String subStr : s.split(regex.toString()))
                count = Math.max(count, longestSubstring(subStr, k));
            return count;
        }
        return s.length();
    }

    public int longestSubstring2(String s, int k)
    {
        if (s.length() < k)
            return 0;

        char[] chs = s.toCharArray();
        Map<Character, Integer> charCnt = new HashMap<>();
        for (int i = 0; i < chs.length; i++)
        {
            char c = chs[i];
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        StringBuilder regex = new StringBuilder("[");
        for(char c : charCnt.keySet())
        {
            if(charCnt.get(c) < k)
                regex.append(c);
        }
        regex.append(']');

        if(regex.length() > "[]".length())
        {
            int count = 0;
            for(String subStr : s.split(regex.toString()))
                count = Math.max(count, longestSubstring(subStr, k));
            return count;
        }
        return s.length();
    }
    public int longestSubstring1(String s, int k)
    {
        if (s.length() < k)
            return 0;

        Map<Character, Integer> charCnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        String regex = "[";
        for(char c : charCnt.keySet())
        {
            if(charCnt.get(c) < k)
                regex += c;
        }
        regex += "]";

        for(char c : charCnt.keySet())
        {
            if(charCnt.get(c) < k)
            {
                int count = 0;
                for(String subStr : s.split(c+""))
                    count = Math.max(count, longestSubstring1(subStr, k));
                return count;
            }
        }
        return s.length();
    }

    public static void main(String[] args)
    {
        String regex = "[:,.]";
        String[] strs= "I said: you and me, go out.".split(regex);

        System.out.println(regex.length());
        for (String str: strs)
        {
            System.out.println(str);
        }
    }
}
