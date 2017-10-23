package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        HashSet<String> bank2 = new HashSet<>(); // to quick check whether a sequence exists
        bank2.add(start);
        for (String s : bank) {
        	bank2.add(s);
        }
        int dist = 0;
        HashSet<String> visited = new HashSet<>(); // to store visited sequence
        Queue<String> q = new LinkedList<>(); //this is to track all the nodes in the transition i.e every stage
        q.offer(start);
        visited.add(start);
        char[] dict = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String next : findNext(cur, dict, bank2)) {
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
    
    //*********************SHITTY SOLTUION - did not work - Time limit exceeded
    
    
        public int minMutation2(String start, String end, String[] bank) {
            if (bank == null || bank.length == 0) {
                return -1;
            }
            if (start.equals(end)) {
                return 0;
            }
            Set<String> bank2 = new HashSet<>();
            bank2.addAll(Arrays.asList(bank));
            Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>();
            beginSet.add(start);
            endSet.add(end);
            int len = 1;
            char[] charList = new char[]{'A','G','C','T'};
            Set<String> tempSet = new HashSet<>();
            while( !beginSet.isEmpty() && !endSet.isEmpty()){
                
                for(String word : beginSet){
                    char[] charArray = word.toCharArray();
                    for(int i=0; i<word.length(); i++){
                        for(char c : charList){
                            char old = charArray[i];
                            charArray[i] = c;
                            String newWord = String.valueOf(charArray);
                            if(endSet.contains(newWord)){
                                if(bank2.contains(newWord))
                                    return len;
                                else 
                                    return -1;
                            }
                            //check if not visited and in word list
                            if(!visited.contains(newWord) && bank2.contains(newWord)){
                                visited.add(newWord);
                                tempSet.add(newWord);
                            }
                            charArray[i] = old;
                        }
                        
                    }
                   
                }
                beginSet = tempSet;
                len++; 
            }
            return -1;
        }
        
//**********************************Finally understood it
        
            public int minMutation3(String start, String end, String[] bank) {
                
                if(start == null || end == null || start.length() == 0 || end.length() == 0 || bank == null || bank.length == 0)
                   return -1;
                if(start.equals(end))
                    return 0;
                
                Set<String> bank2 = new HashSet<>(), visited = new HashSet<>();
                Queue<String> q = new LinkedList<>();
                //for faster retrieval and checking contains
                for(String s : bank)
                    bank2.add(s);
                char[] dict = {'A','C', 'G','T'};
                int len = 0;
                q.add(start);
                visited.add(start);
                
                while(!q.isEmpty()){
                    //now keep checking if
                    //we get the queue size
                    int size = q.size();
                    //since we are iterating, might as well increase the dist
                    len++;
                    
                    for(int i=0; i<size ; i++){
                        String word = q.poll();
                        for(String newWord : findNext2(word, dict, bank2 )){
                            if (visited.contains(newWord)) {
                                continue;
                            }
                            if(newWord.equals(end)){
                                if(bank2.contains(newWord))
                                    return len;
                                else
                                    return -1;
                            }
                            visited.add(newWord);
                            //add to queue
                            q.offer(newWord);
                        }
                    }
                }
                
                return -1;

            }
            
            private List<String> findNext2(String cur, char[] dict, Set<String> set) {
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