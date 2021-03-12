/**
 * 把树看做一个有向图，利用出度和入度相等来判断
 */
public class Solution331
{
    public boolean isValidSerialization(String preorder)
    {
        if(preorder.equals("#"))    // 特例
            return true;

        int inDegree = 0, outDegree = 0;    // 初始 入度出度
        String[] nodes = preorder.split(","); // 转成数组

        for (int i = 0; i < nodes.length; i++) // 遍历数组
        {
            if(i == 0)  //根节点
            {
                if(nodes[i].equals("#")) // #,#,1 这样的 是非法的
                    return false;
                outDegree += 2;   //根节点  出度+2
                continue;
            }

            if(nodes[i].equals("#")) //null节点，入度+1
                inDegree += 1;
            else {                  // 非空节点 入度+1 出度+2
                inDegree += 1;
                outDegree += 2;
            }

            if(i != nodes.length - 1 && inDegree >= outDegree)
                return false; //一直保持indegree<outdegree，直到最后才indegree==outdegree，做不到就false
        }

        return inDegree == outDegree; // 最后肯定入度==出度
    }
}
