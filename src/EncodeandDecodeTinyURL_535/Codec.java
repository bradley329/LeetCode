package EncodeandDecodeTinyURL_535;

import java.util.HashMap;
import java.util.Map;

public class Codec {

  private Map<String, String> tinyToLongMap = new HashMap<>();
  private Map<String, String> longToTityMap = new HashMap<>();
  private final String HOST = "https://tinyurl.com/";

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    if (longToTityMap.containsKey(longUrl))
      return longToTityMap.get(longUrl);
    String tinyUrl = HOST + (longUrl.hashCode() + System.nanoTime());
    tinyToLongMap.put(tinyUrl, longUrl);
    longToTityMap.put(longUrl, tinyUrl);
    return tinyUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String tinyUrl) {
    return tinyToLongMap.get(tinyUrl);
  }
}
