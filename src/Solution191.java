public class Solution191
{
    public int hammingWeight(int n)
    {
        int count = 0;
        for (int i = 0; i < 32; i++)
        {
            if((i >> 1 & 1) == 1)
                count++;
        }
        return count;
    }
}
