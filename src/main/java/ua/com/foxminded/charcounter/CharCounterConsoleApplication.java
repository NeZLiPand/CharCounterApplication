package ua.com.foxminded.charcounter;

import java.util.Scanner;

import ua.com.foxminded.charcounter.cache.LRUCache;
import ua.com.foxminded.charcounter.cache.LRUCacheImpl;
import ua.com.foxminded.charcounter.provider.ViewProvider;
import ua.com.foxminded.charcounter.provider.ViewProviderImpl;
import ua.com.foxminded.charcounter.service.CharCounter;
import ua.com.foxminded.charcounter.validator.Validator;
import ua.com.foxminded.charcounter.validator.ValidatorImpl;

public class CharCounterConsoleApplication {
    private static final String MESSAGE_TO_USER = "Please, enter your message or enter 'q' that exit app:\n";

    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        ViewProvider viewProvider = new ViewProviderImpl();
        LRUCache lruCache = new LRUCacheImpl(3);
        CharCounter charCounter = new CharCounter(lruCache, validator);
        Scanner streamIn = new Scanner(System.in);
        String receivedText = "";
        System.out.println(MESSAGE_TO_USER);
        while (!("q".equals(receivedText = streamIn.nextLine()))) {
            System.out.println(new StringBuilder().append(viewProvider.provideView(charCounter.charCounting(receivedText)))
                                                  .append("\n\n")
                                                  .append(MESSAGE_TO_USER)
                                                  .toString());
        }
        streamIn.close();
    }

}
