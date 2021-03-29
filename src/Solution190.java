public class Solution190
{
    // you need treat n as an unsigned value
    public int reverseBits(int n)
    {
        int ret = 0;
        for(int i = 0; i < 32; i ++)
        {
            int bit = (n >> i) & 1;
            ret += bit << (31 - i);
        }
        return ret;
    }
}
