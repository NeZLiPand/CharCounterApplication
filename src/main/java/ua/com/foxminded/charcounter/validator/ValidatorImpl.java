package ua.com.foxminded.charcounter.validator;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(String receivedText) {
        if (receivedText.isEmpty()) {
            throw new IllegalArgumentException("Received text is empty!");
        }
    }

}
