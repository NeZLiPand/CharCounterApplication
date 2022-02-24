package ua.com.foxminded.charcounter.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ViewProviderTest {
    ViewProvider viewProvider = new ViewProviderImpl();

    @Test
    void testProvideView_shouldReturnAmountCharacterView_whenInputObjectTheResultOfCountingTheCharactersOfStringWithOneCharacter() {
        Map<Character, Integer> recordsChars = new LinkedHashMap<>();
        recordsChars.put('!', 1);
        assertEquals("\"!\" - 1\n", viewProvider.provideView(recordsChars));
    }

    @Test
    void testProvideView_shouldReturnAmountCharacterView_whenInputObjectTheResultOfCountingTheCharactersOfStringWithTwoCharacter() {
        Map<Character, Integer> recordsChars = new LinkedHashMap<>();
        recordsChars.put('!', 1);
        recordsChars.put('Q', 1);
        assertEquals("\"!\" - 1\n"
                     + "\"Q\" - 1\n", viewProvider.provideView(recordsChars));
    }

    @Test
    void testProvideView_shouldReturnAmountCharacterView_whenInputObjectTheResultOfCountingTheCharactersOfStringWithLargeNumberCharacter() {
        Map<Character, Integer> recordsChars = new LinkedHashMap<>();
        recordsChars.put('h', 1);
        recordsChars.put('e', 2);
        recordsChars.put('l', 3);
        recordsChars.put('o', 2);
        recordsChars.put(' ', 6);
        recordsChars.put('w', 1);
        recordsChars.put('r', 1);
        recordsChars.put('d', 1);
        recordsChars.put('!', 2);
        assertEquals("\"h\" - 1\n"
                     + "\"e\" - 2\n"
                     + "\"l\" - 3\n"
                     + "\"o\" - 2\n"
                     + "\" \" - 6\n"
                     + "\"w\" - 1\n"
                     + "\"r\" - 1\n"
                     + "\"d\" - 1\n"
                     + "\"!\" - 2\n", viewProvider.provideView(recordsChars));
    }

}
