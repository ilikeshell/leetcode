import java.util.Arrays;

public class Solution354
{
    private int[] table;
    public static void main(String[] args)
    {
        //int[][] envelopes = {{5,4},{6,4},{6,7},{2,3},{2,3},{2,4}};
        //int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        //int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        Solution354 s = new Solution354();
        System.out.println(s.maxEnvelopes(envelopes));
        System.out.println(Arrays.toString(s.table));
    }



    public int maxEnvelopes(int[][] envelopes)
    {
        /** 对二维数组进行排序 */
        for (int i = 0; i < envelopes.length; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < envelopes.length; j++)
            {
                if(envelopes[j][0] < envelopes[minIndex][0] ||
                        (envelopes[j][0] == envelopes[minIndex][0] && envelopes[j][1] < envelopes[minIndex][1]))
                    minIndex = j;
            }
            if(minIndex != i)
            {
                int[] temp = envelopes[i];
                envelopes[i] = envelopes[minIndex];
                envelopes[minIndex] = temp;
            }
        }


        /** 建立一个表，保存中间结果 */
        table = new int[envelopes.length];

        int max = 0;
        for (int i = 0; i < table.length; i++)
        {
            int t = findMax(i, envelopes);
            if(t > max)
                max = t;
        }

        return max;
    }

    public int findMax(int startIndex, int[][] envelopes)
    {
        if(startIndex == envelopes.length - 1)
        {
            table[startIndex] = 1;
        }

        if(table[startIndex] > 0)
            return table[startIndex];

        int max = 0;
        for (int i = startIndex + 1; i < envelopes.length; i++)
        {
            if(envelopes[i][0] > envelopes[startIndex][0] &&
                envelopes[i][1] > envelopes[startIndex][1])
            {
                int t = findMax(i, envelopes);
                if(t > max) max = t;
            }
        }

        table[startIndex] = max + 1;
        return table[startIndex];
    }

    public int findMax2(int startIndex, Envelope[] envArray)
    {
        if(startIndex == envArray.length - 1)
        {
            if(table[startIndex] == 0)
                table[startIndex] = 1;

            return table[startIndex];
        }


        if(table[startIndex] > 0)
            return table[startIndex];

        int[] count = new int[envArray.length - 1 - startIndex];
        for (int i = startIndex + 1; i < envArray.length; i++)
        {
            if(envArray[startIndex].getW() < envArray[i].getW() &&
                    envArray[startIndex].getH() < envArray[i].getH())
            {
                count[i - startIndex - 1] = findMax2(i, envArray);
            }
        }
        Arrays.sort(count);

        table[startIndex] = count[count.length-1] + 1;
        return table[startIndex];
    }

    public int maxEnvelopes2(int[][] envelopes)
    {
        Envelope[] envArray = new Envelope[envelopes.length];
        int max = 0;

        /** 初始化信封对象数组 */
        for (int i = 0; i < envelopes.length; i++)
        {
            Envelope e = new Envelope();
            e.setW(envelopes[i][0]);
            e.setH(envelopes[i][1]);
            envArray[i] = e;
        }

        /** 排序 */
        Arrays.sort(envArray);
        table = new int[envArray.length];

        for (int i = 0; i < envArray.length; i++)
        {
            int count = findMax2(i, envArray);
            if(count > max)
                max = count;
        }
        return max;
    }

    class Envelope implements Comparable<Envelope>
    {
        private int w;
        private int h;

        public void setW(int w)
        {
            this.w = w;
        }

        public void setH(int h)
        {
            this.h = h;
        }

        public int getH()
        {
            return this.h;
        }

        public int getW()
        {
            return this.w;
        }

        @Override
        public int compareTo(Envelope o)
        {
            if((this.w < o.w) || (this.w == o.w && this.h < o.h))
                return -1;
            else if((this.w > o.w) || (this.w == o.w && this.h > o.h))
                return 1;
            else
                return 0;
        }
    }
}
