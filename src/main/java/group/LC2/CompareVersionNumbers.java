package group.LC2;

import java.util.*;

public class CompareVersionNumbers {


    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null)
            return -1;
        //ensure that both versions have a .
        if(!version1.contains("\\.")){
           version1 += ".0"; 
        }
        if(!version2.contains("\\."))
            version2 += ".0";
        //the inputs can also contain more than 1 .
        //System.out.println(version1+","+version2);
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        //System.out.println(Arrays.toString(v1));
        //System.out.println(Arrays.toString(v2));
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        for(String s : v1)
            n1.add(Integer.parseInt(s));
        for(String s : v2)
            n2.add(Integer.parseInt(s));
        int i = 0;
        while(i < n1.size() || i < n2.size()){
            int num1 = 0, num2 = 0;
            if(i < n1.size())
                num1 = n1.get(i);
            if(i < n2.size())
                num2 = n2.get(i);
            if(num1 > num2)
                return 1;
            else if(num2 > num1)
                return -1;
            i++;
        }
        return 0;
    }
}