package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class KillProcess {
	
	/*public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //do the initial validation
        if(pid == null && ppid == null )
            return new ArrayList<Integer>();
        if(pid == null || ppid == null)
            return new ArrayList<Integer>();
        //if its all the processes
        if(kill == 0)
            return new ArrayList<Integer>();
        HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        //insertion phase
        for(int i=0; i<ppid.size(); i++){
            Integer currPid = pid.get(i);
            Integer currPpid = ppid.get(i);
            if(!map.containsKey(currPpid)){
            	List<Integer> list = new ArrayList<Integer>();
            	list.add(currPid);
                map.put(currPpid, list);
            }
            else{
            	List<Integer> temp =  map.get(currPpid);
                temp.add(currPid);
                map.put(currPpid, temp);
            }
            //now lets append to the values
        }
        //prep phase
        for(Entry<Integer, List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            //check if this key is present as a value in any list
            //get all the values
            Collection<List<Integer>> valueList =  map.values();
            for(List<Integer> value : valueList){
                if(value.contains(key))
                    value.addAll(list);
            }
        }
        //now find the number of process which'll be killed
        List<Integer> toKill = map.get(kill);
        if(toKill != null)
            toKill.add(kill);
        else{
            toKill = new ArrayList<Integer>();
            toKill.add(kill);
        }
        return toKill;
    }*/
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<ppid.size(); i++){
            Integer currPid = pid.get(i);
            Integer currPpid = ppid.get(i);
            if(!map.containsKey(currPpid)){
            	List<Integer> list = new ArrayList<Integer>();
            	list.add(currPid);
                map.put(currPpid, list);
            }
            else{
                List<Integer> temp =  map.get(currPpid);
                temp.add(currPid);
                map.put(currPpid, temp);
            }
        }
        
        //now what we need is a stack for doing a simple dfs
        //we put the kill inside the stack
        //we keep going and deleting the nodes which have 'kill' as their parent
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(kill);
        List<Integer> toKill = new ArrayList<Integer>();
        while(stack.size() > 0){
            //get the element's children
            int val = stack.pop();
            toKill.add(val);
            if(map.containsKey(val)){
            List<Integer> listVal = map.get(val);
            stack.addAll(listVal);
            }
            //System.out.println(toKill);
        }
        return toKill;
    }
}
