public class Solution50
{
    public static void main(String[] args)
    {
        Solution50 s = new Solution50();
        System.out.println(s.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int m)
    {
        double ret = 0;
        int sign = 1;
        long n = m; //2.00000 -2147483648 这个例子的需要一个强制类型转换转成long

        if(m < 0)
        {
            sign = -1;
            n = -1 * n;
        }

        ret = sign == 1 ? Pow(x,n) : 1.0 / Pow(x,n);

        return ret;
    }

    public double Pow(double x, long n)
    {
        double ret = 0;

        if(n == 1)
            ret = x;
        else if(n == 0)
            ret = 1;
        else
        {
            ret = Pow(x, n/2);
            ret = n % 2 == 0 ? ret * ret : x * ret * ret;
        }

        return ret;
    }
}
