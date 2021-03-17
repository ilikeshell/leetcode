import java.util.ArrayList;
import java.util.Collections;

public class Solution155
{
}

class MinStack {
    private ArrayList<Integer> s;
    int minValue;
    /** initialize your data structure here. */
    public MinStack() {
        s = new ArrayList<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        s.add(x);
        minValue = Collections.min(s);
    }

    public void pop() {
        if(s.size() > 0)
            s.remove(s.size() - 1);

        if(s.size() > 0)
            minValue = Collections.min(s);
    }

    public int top() {
       return s.get(s.size() - 1);
    }

    public int getMin() {
        return minValue;
    }
}
