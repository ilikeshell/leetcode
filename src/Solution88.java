class Solution88 {
    public static void main(String[] args)
    {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] t = new int[m + n];

        int i, j, k;
        for(i = 0, j = 0, k = 0; i < m && j < n && k < m + n;  )
        {
            if(nums1[i] <= nums2[j])
            {
                t[k] = nums1[i];
                i++;
                k++;
            }
            else
            {
                t[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < m)
        {
            t[k] = nums1[i];
            i++;
            k++;
        }

        while(j < n)
        {
            t[k] = nums2[j];
            j++;
            k++;
        }
        System.arraycopy(t, 0, nums1, 0, m + n);
    }
}