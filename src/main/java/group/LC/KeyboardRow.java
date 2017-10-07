package group.LC;

public class KeyboardRow {
	
	//*******************************more optimal solution
	//******************************************
	   public String[] findWords(String[] words) {
	        String top = "qwertyuiop";
	        String middle = "asdfghjkl";
	        String bottom = "zxcvbnm";
	        if(words == null)
	            return null;
	        List<String> l = new ArrayList<String>();
	        for(String s : words){
	                String target = Character.toLowerCase(s.charAt(0))+"";
	                if(top.contains(target))
	                    restContains(s, top, l);
	                else if(middle.contains(target))
	                    restContains(s,middle,l);
	                else
	                    restContains(s,bottom,l);
	        }
	        String[] ans = new String[l.size()];
	        ans = l.toArray(ans);
	        return ans;
	    }
	    
	    public void restContains(String target, String source, List<String> l){
	        //have to check if each char of target is in the source
	        for(int i=1; i<target.length(); i++){
	            String reqdChar = Character.toLowerCase(target.charAt(i))+"";
	            if(!source.contains(reqdChar))
	                return;
	        }
	        l.add(target);
	    }

	}