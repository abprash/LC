package group.LC4;

//https://leetcode.com/problems/encode-and-decode-tinyurl/description/

public class EncodeDecodeTinyUrl {
	Map<String, String> longToShort;
	Map<String, String> shortToLong;

	int counter = 0;

	public EncodeDecodeTinyUrl(){
	        longToShort = new HashMap<>();
	        shortToLong = new HashMap<>();
	    }

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (longToShort.containsKey(longUrl))
			return longToShort.get(longUrl);
		else {
			this.counter++;
			longToShort.put(longUrl, Integer.toString(counter));
			shortToLong.put(Integer.toString(counter), longUrl);
			return Integer.toString(counter);
		}

	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shortToLong.get(shortUrl);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));