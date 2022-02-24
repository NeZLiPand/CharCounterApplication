package ua.com.foxminded.charcounter.service;

import java.util.LinkedHashMap;
import java.util.Map;

import ua.com.foxminded.charcounter.cache.LRUCache;
import ua.com.foxminded.charcounter.validator.Validator;

public class CharCounter {
    private final LRUCache lruCache;
    private final Validator validator;

    public CharCounter(LRUCache lruCache,
                       Validator validator) {
        this.lruCache = lruCache;
        this.validator = validator;
    }

    public Map<Character, Integer> charCounting(String receivedText) {
        validator.validate(receivedText);
        if (!lruCache.containsKey(receivedText)) {
            lruCache.put(receivedText, countUniqueCharacters(receivedText));
        }
        return lruCache.get(receivedText);
    }

    public Map<Character, Integer> countUniqueCharacters(String receivedText) {
        int numberOfOccurrences = 1;
        char[] receivedTextChars = receivedText.toCharArray();
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        for (int kIterator = 0; kIterator < receivedTextChars.length; kIterator++) {
            uniqueChars.merge(receivedTextChars[kIterator], numberOfOccurrences, (oldValue,
                                                                                  newValue) -> ++oldValue);
        }
        return uniqueChars;
    }

}
