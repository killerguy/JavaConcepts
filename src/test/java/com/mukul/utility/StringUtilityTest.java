package com.mukul.utility;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.mukul.utility.StringUtility.*;
import static org.junit.Assert.*;

public class StringUtilityTest {

    private static final String DASH = "-";
    private static final String INPUT_VALUE = "anyValue";
    private static final Predicate<String> NULL_STRING_PREDICATE = Objects::isNull;
    private static final Supplier<String> NULL_STRING_MSG_SUPPLIER = () -> "'value' should be not null.";

    @Test
    public void shouldReturnActualValue() {
        assertEquals(INPUT_VALUE, getActualOrDefaultValue(INPUT_VALUE, DASH));
        assertEquals(INPUT_VALUE, getActualValue(INPUT_VALUE));
    }

    @Test
    public void shouldReturnDefaultValueWhenActualValueIsNotPresent() {
        assertEquals(DASH, getActualOrDefaultValue(null, DASH));
        assertEquals(DASH, getActualOrDefaultValue("", DASH));
        assertEquals(DASH, getActualValue(""));
    }

    @Test
    public void shouldValidResultForIsEmptyAndNotEmptyStrings() {
        assertTrue(isEmpty(""));
        assertFalse(isNotEmpty(""));

        assertTrue(isNotEmpty(INPUT_VALUE));
        assertTrue(isEmpty(null));
        assertFalse(isNotEmpty(null));

    }

    @Test
    public void shouldTestNull() {
        assertTrue(StringUtils.isNotEmpty(nullGuard(() -> getActualValue("Abc"))));
        assertFalse(StringUtils.isNotEmpty(nullGuard(() -> null)));

    }

    @Test
    public void shouldTestAnagram() {
        assertTrue(areAnagram("abc", "cba"));
        assertFalse(areAnagram("", null));
        assertFalse(areAnagram(INPUT_VALUE, "anyResult"));
    }

    @Test
    public void shouldTestTrimIgnoreCase() {
        assertTrue(equalsIgnoreCaseWithTrim("abc", "ABC"));
        assertTrue(equalsIgnoreCaseWithTrim(null, null));

        assertFalse(equalsIgnoreCaseWithTrim(INPUT_VALUE, "anyResult"));
        assertFalse(equalsIgnoreCaseWithTrim(INPUT_VALUE, null));
    }

    @Test
    public void shouldTestValidateFunction() {
        assertEquals(3, testLength("abc"));
        assertEquals(0, testLength(""));
    }

    @Test(expected = Exception.class)
    public void shouldTestValidateFunctionForNullCase() {
        testLength(null);
    }

    @Test
    public void shouldTestValidateFunctionForInValidCase() {
        try {
            testLength(null);
        } catch (Exception exception) {
            assertEquals(NULL_STRING_MSG_SUPPLIER.get(), exception.getMessage());
        }
    }

    @Test
    public void shouldReturnBase64EncodedValue() {
        getUTF8Bytes(INPUT_VALUE);
        assertEquals("YW55VmFsdWU=", base64Encode(INPUT_VALUE));
    }

    @Test
    public void shouldReturnBase64DecodedValue() {
        assertEquals(INPUT_VALUE, base64Decode("YW55VmFsdWU="));
    }

    @Test
    public void shouldDetermineInputIsString() {
        assertTrue(isString("YW55VmFsdW"));
        assertFalse(isString(123));
    }

    private int testLength(String value) {
        validate(value, NULL_STRING_PREDICATE, NULL_STRING_MSG_SUPPLIER);
        return value.length();
    }

}
