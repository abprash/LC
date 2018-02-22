package group.LC;

public class ValidAnagram {

//****************************Use a hashmap for a more generic approach
	
	//if all the unicode characters are used then this will fail
	
	
	
	
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        
        int[] occ1 = getOccurrences(s);
        boolean res = checkOccurrences( t, occ1);
        return res;
    }
    
    
    //only for ascii characters for now
    public int[] getOccurrences(String s){
        
        int[] occ = new int[256];
        for(int i=0; i<s.length(); i++){
            occ[s.charAt(i)]++;
        }
        return occ;
    }
    
    public boolean checkOccurrences(String s, int[] occ){
        for(int i=0; i<s.length(); i++){
            if(occ[s.charAt(i)] == 0)
                return false;
            else
                occ[s.charAt(i)]--;
        }
        int sum = 0;
        for(int i=0; i<occ.length; i++){
            sum+=occ[i];
        }
        return sum == 0 ? true: false;
    }
    
}