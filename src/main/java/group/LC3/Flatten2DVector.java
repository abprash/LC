package group.LC3;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {

}


//https://leetcode.com/problems/flatten-2d-vector/discuss/67652/7-9-lines-added-Java-and-C++-O(1)-space.

class Vector2D_1 implements Iterator<Integer> {

    Iterator<List<Integer>> outer;
    Iterator<Integer> inner;
    public Vector2D_1(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
        if(outer.hasNext())
            inner = outer.next().iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return inner.next();
    }

    @Override
    public boolean hasNext() {
        while ((inner == null || !inner.hasNext()) && outer.hasNext())
            inner = outer.next().iterator();
        return inner != null && inner.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */


//https://leetcode.com/problems/flatten-2d-vector/discuss/67656/Java-Solution-Beats-60.10

class Vector2D implements Iterator<Integer> {

    int i, j;
    List<List<Integer>> list;
    public Vector2D(List<List<Integer>> vec2d) {
        i = 0;
        j = 0;
        list = vec2d;
    }

    @Override
    public Integer next() {
        return list.get(i).get(j++);
    }

    @Override
    public boolean hasNext() {
        while(i < list.size()){
            if(j < list.get(i).size())
                return true;
            else{
                i++;
                j = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */