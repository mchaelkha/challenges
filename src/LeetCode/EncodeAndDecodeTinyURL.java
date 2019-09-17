package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    class Codec {

        Map<String, String> URLs = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String hash = String.valueOf(longUrl.hashCode());
            URLs.put(hash, longUrl);
            return hash;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return URLs.get(shortUrl);
        }
    }
}
