import java.util.ArrayList;
import java.util.List;

class Solution77
{
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return results;
    }

    private void backtracking(int n, int k, int startIndex)
    {
        if(path.size() == k)
        {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++)
        {
            path.add(i);
            backtracking(n, k, i+1);
            path.remove(path.size() - 1);
        }
    }
}