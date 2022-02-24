package ua.com.foxminded.charcounter.cache;

import java.util.Map;

public interface LRUCache {

    public Map<Character, Integer> get(String key);

    public String getAll();

    public Map<Character, Integer> put(String key,
                                       Map<Character, Integer> value);

    public boolean putAll(Map<String, Map<Character, Integer>> cache);

    public Map<Character, Integer> remove(String key);

    public boolean remove(String key,
                          Map<Character, Integer> value);

    public boolean removeAll();

    public boolean containsKey(String key);

}
