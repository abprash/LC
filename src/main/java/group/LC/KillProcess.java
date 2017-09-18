package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KillProcess {
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //do the initial validation
        if(pid == null && ppid == null )
            return new ArrayList<Integer>();
        if(pid == null || ppid == null)
            return new ArrayList<Integer>();
        //if its all the processes
        if(kill == 0)
            return new ArrayList<Integer>();
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
        System.out.println(map);
        
        //now find the number of process which'll be killed
        List<Integer> toKill = map.get(kill);
        for(int temppid : toKill){
            toKill
        }
        toKill.add(kill);
        return toKill;
    }
	
	public static void main(String[] args){
		new KillProcess().killProcess(Arrays.As
	}

}
