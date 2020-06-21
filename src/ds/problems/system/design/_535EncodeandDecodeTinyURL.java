package ds.problems.system.design;
//https://leetcode.com/problems/encode-and-decode-tinyurl/
//535. Encode and Decode TinyURL

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _535EncodeandDecodeTinyURL {

    private Map<String, String> urlToKey = new HashMap<>();
    private Map<String, String> keyToUrl = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = urlToKey.get(longUrl);
        if (key == null) {
            do {
                key = generateShortUrl(longUrl);
            } while (keyToUrl.containsKey(key));
            urlToKey.put(longUrl, key);
            keyToUrl.put(key, longUrl);
        }
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return keyToUrl.get(shortUrl);
    }

    private String generateShortUrl(String url) {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++)
            sb.append(s.charAt(random.nextInt(s.length())));
        return sb.toString();
    }
}
