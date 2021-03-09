public class Solution1047
{
    public String removeDuplicates(String S)
    {
        char[] chs = S.toCharArray();
        int i = 0;
        int len = chs.length;

        while (i >= 0 && i < len - 1)
        {
            //如果下一个相邻字母不相等，i前进
            if(i + 1 < len && chs[i] != chs[i + 1])
                i++;
            else
            {
                //找到下一个不相等的字母
                //int j = i + 1;
               // while(j < len && chs[i] == chs[j])
                //    j++;
                // int temp = j - i;

                //挪动并删除相邻的两个相同字符
                int k = i;
                int j = i + 2;
                while(j < len)
                    chs[k++] = chs[j++];
                len = len - 2;  //数组长度缩短
                if(i > 0)  i--;   //后退一步
            }
        }
        return new String(chs, 0, len);
    }

    public static void main(String[] args)
    {
        Solution1047 s = new Solution1047();
        System.out.println(s.removeDuplicates("aaaaaaaaa"));
    }
}
