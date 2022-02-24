package ua.com.foxminded.charcounter.provider;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ViewProviderImpl implements ViewProvider {

    @Override
    public String provideView(Map<Character, Integer> uniqueChars) {
        StringBuilder skechCharCounter = new StringBuilder();
        Iterator<Entry<Character, Integer>> iterator = uniqueChars.entrySet()
                                                                  .iterator();
        Entry<Character, Integer> uniqueChar;
        while (iterator.hasNext()) {
            uniqueChar = iterator.next();
            skechCharCounter.append('"')
                            .append(uniqueChar.getKey())
                            .append("\" - ")
                            .append(uniqueChar.getValue())
                            .append('\n');
        }
        return skechCharCounter.toString();
    }
}
