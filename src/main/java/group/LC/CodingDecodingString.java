package group.LC;

/*
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

		Machine 1 (sender) has the function:
		
		string encode(vector<string> strs) {
		  // ... your code
		  return encoded_string;
		}
		Machine 2 (receiver) has the function:
		vector<string> decode(string s) {
		  //... your code
		  return strs;
		}
		So Machine 1 does:
		
		string encoded_string = encode(strs);
		and Machine 2 does:
		
		vector<string> strs2 = decode(encoded_string);
		strs2 in Machine 2 should be the same as strs in Machine 1.
		
		Implement the encode and decode methods.
 * 
 * 
 * 
 * */
public class CodingDecodingString {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        String delim = "|";
        if(strs == null || strs.size() == 0)
            return ans;
        else{
            for(String s : strs){
                sb.append(s.length());
                sb.append(delim);
                sb.append(s);
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> l = new ArrayList<>();
        int index = 0;
        while(index < s.length()){
            //get the length of the string first
            int pipe =  s.indexOf("|",index );
            //next the len
            int size = Integer.valueOf(s.substring(index, pipe));
            l.add(s.substring(pipe + 1, pipe + size+1));
            index = pipe + size + 1;
        }
        
        return l;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));