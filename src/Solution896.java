public class Solution896
{
    public boolean isMonotonic(int[] A)
    {
        int i, j;
        for (i = 1; i < A.length; i++)
        {
            if (A[i - 1] > A[i])
                break;
        }

        for (j = 1; j < A.length; j++)
        {
            if (A[j - 1] < A[j])
                break;
        }

        return (i == A.length || j == A.length ? true : false);
    }

    public static void main(String[] args)
    {
        int[] A = {6,5,4,9};
        System.out.println(new Solution896().isMonotonic(A));
    }
}
