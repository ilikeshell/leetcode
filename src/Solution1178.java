import java.util.*;

public class Solution1178
{
    private int stringToBits(String str)
    {
        int mask = 0;
        for (int i = 0; i < str.length(); i++)
        {
            mask |= 1 << str.charAt(i) - 'a';
        }
        return mask;
    }

    private int getCnt(Map<Integer, Integer> map, String str) {
        int ans = 0;
        int m = str.length();
        char[] cs = str.toCharArray();
        int first = cs[0] - 'a';
        for (int i = 0; i < (1 << (m - 1)); i++) {
            int u = 1 << first;
            for (int j = 1; j < m; j++) {
                if (((i >> (j - 1)) & 1) != 0) u += 1 << (cs[j] - 'a');
            }
            if (map.containsKey(u)) ans += map.get(u);
        }
        return ans;
    }


    private int getCount(Map<Integer, Integer> map, String str)
    {
        int count = 0;

        for (int i = 1; i < 1 << (str.length() - 1); i++)
        {
            int key =  1 << (str.charAt(0) - 'a');
            for (int j = 0; j < str.length(); j++)
            {
                if((i >> j & 1) == 1)
                    key |= 1 << (str.charAt(j) - 'a');
                if(map.containsKey(key))
                    count += map.get(key);
            }
        }
        return count;
    }


    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles)
    {
        Map<Integer, Integer> wordsMap = new HashMap<>();
        for (String w: words)
        {
            int mask = stringToBits(w);
            wordsMap.put(mask, wordsMap.getOrDefault(mask,0)+1);
        }

        List<Integer> results = new ArrayList<>();
        for (String p: puzzles)
        {
            results.add(getCnt(wordsMap, p));
        }
        return results;
    }

    public List<Integer> findNumOfValidWords1(String[] words, String[] puzzles)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++)
        {
            int count = 0;
            for (int j = 0; j < words.length; j++)
            {
                if(isPuzzle(puzzles[i], words[j]))
                    count++;
            }
            ret .add(count);
        }
        return ret;
    }

    private boolean isPuzzle(String puzzle, String word)
    {
        char[] puzzleArray = puzzle.toCharArray();
        char[] wordArray = word.toCharArray();
        Arrays.sort(puzzleArray);
        Arrays.sort(wordArray);

        if(Arrays.binarySearch(wordArray, puzzle.charAt(0)) < 0)
            return false;

        /*if(!word.contains(puzzle.charAt(0) + ""))
            return false;*/

        for (int i = 0; i < wordArray.length; i++)
        {
            if(i - 1 >= 0 && wordArray[i] == wordArray[i-1])
                continue;
            if(Arrays.binarySearch(puzzleArray, wordArray[i]) < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {

        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        List<Integer> list = new Solution1178().findNumOfValidWords(words,puzzles);
        System.out.println(list);



       /* char[] s = {'a','b','c','d'};

        int len = 1 << s.length;
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < s.length; j++)
            {
                if((i >> j & 1) == 1)
                    System.out.print(s[j]);
            }
            System.out.print(" ");
        }
*/

    }
}
