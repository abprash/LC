package group.LC;

public class MinimumGeneticMutation {

public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        HashSet<String> set = new HashSet<>(); // to quick check whether a sequence exists
        set.add(start);
        for (String s : bank) {
            set.add(s);
        }
        int dist = 0;
        HashSet<String> visited = new HashSet<>(); // to store visited sequence
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        char[] dict = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String next : findNext(cur, dict, set)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return dist;
                    }
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        return -1;
    }
    
    private List<String> findNext(String cur, char[] dict, HashSet<String> set) {
        List<String> res = new ArrayList<>();
        // traverse all the possible sequence cases
        for (int i = 0; i < cur.length(); i++) {
            for (char ch : dict) {
                if (ch == cur.charAt(i)) {
                    continue;
                }
                char[] temp = cur.toCharArray();
                temp[i] = ch;
                String next = new String(temp);
                if (set.contains(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }
}