public class Codec {
    
    HashMap<Integer, String> hmap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        int hashedUrl = longUrl.hashCode();
        hmap.put(hashedUrl, longUrl);
        return "http://tinyurl.com/"+hashedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        shortUrl = shortUrl.replace("http://tinyurl.com/", "");
        if(hmap.containsKey(Integer.parseInt(shortUrl))){
            return hmap.get(Integer.parseInt(shortUrl));
        }else {
            return "";
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));