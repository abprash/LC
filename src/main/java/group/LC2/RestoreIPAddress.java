package group.LC2;

import java.util.*;

public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        //we need to maintain the ans, the input string, ip valid string built so far,
        //ans the index to start from and the count of the dots so far
        backtrack(arr, 0, new StringBuilder(), ans, 0);
        return ans;
    }
    
    
    
    private void backtrack(char[] arr, int startIdx, StringBuilder ip, List<String> ips, int count){
    if(count > 4) return;
    if(count == 4){
        if(startIdx == arr.length){
            ips.add(ip.toString());
        }
        return;
    }
    
    int num = 0, ipLen = ip.length();
    for(int i = startIdx; i <= startIdx+3 && i < arr.length; i++){
        num = num*10 + arr[i]-'0';
        if(num >= 256) break;
        
        ip.append(num);
        if(count != 3) ip.append('.'); // the last section should not append '.'
        backtrack(arr, i+1, ip, ips, count+1);
        ip.setLength(ipLen);
        
        if(num == 0) break; // if num starts with 0, only allows a single 0
    }
}
}