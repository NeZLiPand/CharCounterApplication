package ua.com.foxminded.charcounter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.charcounter.cache.LRUCache;
import ua.com.foxminded.charcounter.provider.ViewProvider;
import ua.com.foxminded.charcounter.validator.Validator;

@ExtendWith(MockitoExtension.class)
class CharCounterTest {

    @Mock
    private ViewProvider viewProvider;
    @Mock
    private LRUCache lruCache;
    @Mock
    private Validator validator;

    @InjectMocks
    private CharCounter charCounter;

    @Test
    void testProvideMath_shouldReturnObjectCharCounterResultWithCorrectFields_whenReceivedText() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('h', 1);
        uniqueChars.put('e', 1);
        uniqueChars.put('l', 3);
        uniqueChars.put('o', 2);
        uniqueChars.put(' ', 1);
        uniqueChars.put('w', 1);
        uniqueChars.put('r', 1);
        uniqueChars.put('d', 1);
        uniqueChars.put('!', 1);
        assertEquals(uniqueChars, charCounter.countUniqueCharacters("hello world!"));
    }

    @Test
    void testProvideMath_shouldReturnObjectCharCounterResultWithCorrectFields_whenReceivedTextWithOneSymbol() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('!', 1);
        assertEquals(uniqueChars, charCounter.countUniqueCharacters("!"));
    }

    @Test
    void testProvideMath_shouldReturnObjectCharCounterResultWithCorrectFields_whenReceivedTextWithTwoDifferentSymbol() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('!', 1);
        uniqueChars.put('1', 1);
        assertEquals(uniqueChars, charCounter.countUniqueCharacters("!1"));
    }

    @Test
    void testProvideMath_shouldReturnObjectCharCounterResultWithCorrectFields_whenReceivedTextWithTwoSameSymbol() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('a', 3);
        assertEquals(uniqueChars, charCounter.countUniqueCharacters("aaa"));
    }

    @Test
    void testProvideMath_shouldReturnObjectCharCounterResultWithCorrectFields_whenReceivedTextWithTwoSameSymbolButDifferentCase() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('A', 2);
        uniqueChars.put('a', 2);
        assertEquals(uniqueChars, charCounter.countUniqueCharacters("AaAa"));
    }

    @Test
    void TestCharCounting_shouldReturnAmountCharacterView_whenInputString() {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('h', 1);
        uniqueChars.put('e', 2);
        uniqueChars.put('l', 3);
        uniqueChars.put('o', 2);
        uniqueChars.put(' ', 6);
        uniqueChars.put('w', 1);
        uniqueChars.put('r', 1);
        uniqueChars.put('d', 1);
        uniqueChars.put('!', 2);
        uniqueChars.put('M', 1);
        uniqueChars.put('y', 1);
        uniqueChars.put('n', 1);
        uniqueChars.put('a', 1);
        uniqueChars.put('m', 1);
        uniqueChars.put('i', 1);
        uniqueChars.put('s', 3);
        uniqueChars.put('G', 4);
        uniqueChars.put('I', 3);
        uniqueChars.put('O', 1);
        uniqueChars.put('V', 1);
        uniqueChars.put('A', 1);
        uniqueChars.put('N', 2);
        uniqueChars.put('R', 1);
        doReturn(uniqueChars).when(lruCache)
                             .get(any());
        doReturn(false).when(lruCache)
                       .containsKey(anyString());
        assertEquals(uniqueChars, charCounter.charCounting("hello world! My name is GIOVANNI GIORGIO!"));
    }

    @Test
    void TestCharCounting_shouldReturnAmountCharacterView_whenInputStringWhichIsAlreadyInTheCache() {
        doReturn(true).when(lruCache)
                      .containsKey(anyString());
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        uniqueChars.put('h', 1);
        uniqueChars.put('e', 2);
        uniqueChars.put('l', 3);
        uniqueChars.put('o', 2);
        uniqueChars.put(' ', 6);
        uniqueChars.put('w', 1);
        uniqueChars.put('r', 1);
        uniqueChars.put('d', 1);
        uniqueChars.put('!', 2);
        uniqueChars.put('M', 1);
        uniqueChars.put('y', 1);
        uniqueChars.put('n', 1);
        uniqueChars.put('a', 1);
        uniqueChars.put('m', 1);
        uniqueChars.put('i', 1);
        uniqueChars.put('s', 3);
        uniqueChars.put('G', 4);
        uniqueChars.put('I', 3);
        uniqueChars.put('O', 1);
        uniqueChars.put('V', 1);
        uniqueChars.put('A', 1);
        uniqueChars.put('N', 2);
        uniqueChars.put('R', 1);
        doReturn(uniqueChars).when(lruCache)
                             .get(anyString());
        assertEquals(uniqueChars, charCounter.charCounting("hello world! My name is GIOVANNI GIORGIO!"));
    }

}
