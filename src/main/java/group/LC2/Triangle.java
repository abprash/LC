package group.LC2;

import java.util.*;
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        Iterator<List<Integer>> outer = triangle.iterator();
        
        
        int sum = 0;
        //sum+=triangle.get(0).get(0);
        int[] res = new int[triangle.size() + 1];
        for(int i=triangle.size() - 1; i>=0 ; i--)
        {
            for(int j=0;j<triangle.get(i).size(); j++)
            {
                //return sum + Math.min(triangle.get(j).get(i),triangle.get(j).get(i+1));
                res[j] = Math.min(res[j],res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}