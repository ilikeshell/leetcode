import java.util.Arrays;

public class Solution338
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(new Solution338().countBits(2)));
    }


    public int[] countBits3(int num)
    {
        int[] ret = new int[num+1];
        ret[0] = 0;
        for (int i = 1; i <= num; i++)
        {
            // i&1相当于i%２，但前者要快得多；　ｉ＞＞１相当于ｉ／２
            ret[i] = (i&1) + ret[i>>1];
        }

        return ret;
    }

    public int[] countBits(int num)
    {
        int[] ret = new int[num + 1];

        for (int i = 0; i <= num; i++)
        {
            ret[i] = countOnes(i);
        }

        return ret;
    }

    public int countOnes(int x)
    {
        int ones = 0;
        for (int i = 0; i < 32; i++)
        {
            if ((x >> i & 1) == 1)
                ones++;
        }
        return ones;
    }

    public int[] countBits2(int num)
    {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        for (int i = 1; i <= num; i++)
        {
            ret[i] = (i & 1) == 1 ? ret[i - 1] + 1 : ret[i / 2];
        }

        return ret;
    }
}
