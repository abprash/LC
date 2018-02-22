package group.LC;

public class ZigzagIterator {

}


class ZigzagIterator2 {

    List<Iterator> iteratorList;
    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        iteratorList = new LinkedList<>();
        if(!v1.isEmpty())
            iteratorList.add(v1.iterator());
        if(!v2.isEmpty())
            iteratorList.add(v2.iterator());
    }

    public int next() {
        //we will get the first list
        Iterator<Integer> temp = iteratorList.remove(0);
        int ans = temp.next();
        if(temp.hasNext())
            iteratorList.add(temp);
        return ans;
    }

    public boolean hasNext() {
        return !iteratorList.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */