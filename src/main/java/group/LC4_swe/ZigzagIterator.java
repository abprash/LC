package group.LC4;

public class ZigzagIterator {

    List<List<Integer>> lists = null;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.lists = new LinkedList<>();
        if(v1 != null && v1.size() > 0 )
            lists.add(v1);
        if(v2 != null && v2.size() > 0 )
            lists.add(v2);
    }

    public int next() {
        List<Integer> temp = this.lists.remove(0);
        int ans = temp.remove(0);
        if(temp.size() > 0)
            lists.add(temp);
        return ans;
    }

    public boolean hasNext() {
        return lists.size() > 0 && lists.get(0).size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */