package ua.com.foxminded.charcounter.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidatorImplTest {
    Validator validator = new ValidatorImpl();

    @Test
    void testValidate_shouldReturnIllegalArgumentException_whenInputStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate("");
        });
    }

    @Test
    void testValidate_shouldNotThrowAnExceptio_whenInputText() {
        assertDoesNotThrow(() -> {
            validator.validate("Text");
        });
    }

}
