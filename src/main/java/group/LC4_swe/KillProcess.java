package group.LC4;

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<pid.size(); i++){
            int pidEl = pid.get(i);
            int ppidEl = ppid.get(i);
            if(!map.containsKey(ppidEl))
                map.put(ppidEl, new ArrayList<Integer>());
            map.get(ppidEl).add(pidEl);
        }
        stack.add(kill);
        while(! stack.isEmpty()){
            int toKill = stack.pop();
            set.add(toKill);
            if(map.containsKey(toKill)){
                set.addAll(map.get(toKill));
                stack.addAll(map.get(toKill));
            }
        }
        ans.addAll(set);
        return ans;
    }
}