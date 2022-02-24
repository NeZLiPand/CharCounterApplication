package ua.com.foxminded.charcounter.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LRUCacheImplTest {
    
    @Test
    void testGet_shouldGetEmptyMap_WhenTheCacheDoesNotContainACallableEntry() {
        LRUCache lruCache = new LRUCacheImpl(1);
        assertEquals(Collections.emptyMap(), lruCache.get("test0"));
    }

    @Test
    void testGet_shouldGetData_WhenAddSomeDataToCache() {
        LRUCache lruCache = new LRUCacheImpl(2);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        assertEquals(uniqueChars, lruCache.get("test0"));
    }

    @Test
    void testGetAll_shouldGetAllData_WhenAddSomeDataToCache() {
        LRUCache lruCache = new LRUCacheImpl(2);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('1', 1);
        lruCache.put("test1", uniqueChars);
        assertEquals("{test0={t=2, e=1, s=1, 0=1}, test1={t=2, e=1, s=1, 1=1}}", lruCache.getAll());
    }

    @Test
    void testPut_shouldGetData_whenAddSomeDataToCache() {
        LRUCache lruCache = new LRUCacheImpl(2);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('1', 1);
        lruCache.put("test1", uniqueChars);
        assertEquals("{test0={t=2, e=1, s=1, 0=1}, test1={t=2, e=1, s=1, 1=1}}", lruCache.getAll());
    }

    @Test
    void testPut_shouldGetData_WhenAddSameDataToCache() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('1', 1);
        lruCache.put("test1", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('1', 1);
        lruCache.put("test1", uniqueChars);
        assertEquals("{test0={t=2, e=1, s=1, 0=1}, test1={t=2, e=1, s=1, 1=1}}", lruCache.getAll());
    }

    @Test
    void testPutAll_shouldGetData_WhenAdd() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        Map<String, Map<Character, Integer>> Entries = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        Entries.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        Entries.put("test1", uniqueChars);
        assertTrue(lruCache.putAll(Entries));
    }

    @Test
    void testRemove_shouldDeleteNodeEntryInCache_WhenInputOnlyKeyOfThisNode() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test1", uniqueChars);
        assertEquals(uniqueChars, lruCache.remove("test1"));
    }

    @Test
    void testRemove_shouldDeleteNodeEntryInCache_WhenInputKeyAndValueOfThisNode() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test1", uniqueChars);
        assertTrue(lruCache.remove("test1", uniqueChars));
    }

    @Test
    void testRemoveAll_shouldGetData_WhenAdd() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test1", uniqueChars);
        assertTrue(lruCache.removeAll());
    }

    @Test
    void testContainsKey_shouldGetData_WhenAdd() {
        LRUCache lruCache = new LRUCacheImpl(3);
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('t', 2);
        uniqueChars.put('e', 1);
        uniqueChars.put('s', 1);
        uniqueChars.put('0', 1);
        lruCache.put("test0", uniqueChars);
        assertTrue(lruCache.containsKey("test0"));
    }

}
