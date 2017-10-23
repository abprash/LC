package group.LC;

public class TinyUrl_1 {

    //stores all the long and short URLs
    Map<String, String> shortToLong = new HashMap<>(), longToShort = new HashMap<>();
    
    //stores the last computed shortURL
    private String lastShortUrl = "00000%";
    private String domain = "http://tinyurl.com/";
    
    //computes the next URL
    public String computeNextShortUrl(String lastShortUrl){
        String allChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] lastUrlArray = lastShortUrl.toCharArray();
        //we will see where each char is 
        boolean isDone = false;
        for(int i=lastUrlArray.length-1; i>=0; i--){
            if(lastUrlArray[i] != 'Z'){
                isDone = true;
                //rotate to the next char
                char next = allChars.charAt((allChars.indexOf(lastUrlArray[i]) + 1) % allChars.length());
                lastUrlArray[i] = next;
            }else{
                 char next = allChars.charAt((allChars.indexOf(lastUrlArray[i]) + 1) % allChars.length());
                lastUrlArray[i] = next;
            }
            
            if(isDone)
                break;
        }
        lastShortUrl = new String(lastUrlArray);
        return lastShortUrl;
    }
    
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //check if the given url is in the longToShort map
            // if 
                //present - return it
            //else
                //compute new, and store and update lastShortUrl
        //initial validation
        if(longUrl == null )
            return null;
        if( longUrl.length() == 1)
            return longUrl;
        
        if(longToShort.containsKey(longUrl))
            return longToShort.get(longUrl);
        else{
            //compute the new one
            String shortUrl = computeNextShortUrl(lastShortUrl);
            while(shortToLong.containsKey(shortUrl)){
                //do it again
                 shortUrl = computeNextShortUrl(lastShortUrl);
            }
            //add it to both maps
            longToShort.put(longUrl, shortUrl);
            shortToLong.put(shortUrl, longUrl);
            return shortUrl;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //check if the given url is in the shortToLong map
        //it has to be present
        //return the associated long one
        System.out.println(longToShort);
        if(shortToLong.containsKey(shortUrl))
            return shortToLong.get(shortUrl);
        else
            return "%%";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));