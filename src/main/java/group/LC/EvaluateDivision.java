package group.LC;

public class EvaluateDivision {

}

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            //checking the availability of the nr and dr
            //by default, if they are not present, we are adding them to the map
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        //we are constructing the adj list
        System.out.println(pairs);
        System.out.println(valuesPair);
        
        //now the result
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            //start is the starting nr, end is the final dr, set - used to ensure that we do not get caught in any cycles (which we will),
            //and value -> is the ans for now, because anything multiplied by 1 will not change the ans
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) 
                result[i] = -1.0;
        }
        return result;
    }
   
    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if(set.contains(start))
            return 0.0;//we have reached a cycle
        if(!pairs.containsKey(start))
            return 0.0;//this is for the keys not present in teh map
        if(start.equals(end))
            return value;//we have reached the ans
        set.add(start);
        double ans = 0.0;
        List<String> neighbours = pairs.get(start);
        List<Double> neighbourValues = values.get(start);
        for(int i=0; i<neighbours.size(); i++){
            ans = dfs(neighbours.get(i), end, pairs, values, set, value * neighbourValues.get(i));
            if(ans != 0.0)
                break;//we have found the ans
        }
        set.remove(start);
        return ans;
    }
    
   private double dfs2(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
       //these are to ensure that we do not encounter any cycles 
       if (set.contains(start)) return 0.0;
       //this is to ensure that we do not
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
       
        set.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}