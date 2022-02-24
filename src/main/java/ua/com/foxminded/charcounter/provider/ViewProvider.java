package ua.com.foxminded.charcounter.provider;

import java.util.Map;

public interface ViewProvider {

    public String provideView(Map<Character, Integer> charCounterResult);

}
