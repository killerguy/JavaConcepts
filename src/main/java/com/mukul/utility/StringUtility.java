package com.mukul.utility;

import org.apache.commons.lang.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StringUtility {

    private static final Predicate<String> NULL_STRING_PREDICATE = Objects::isNull;
    private static final Supplier<String> NULL_STRING_MSG_SUPPLIER = () -> "Input should be not null.";


    public static String getActualOrDefaultValue(String input, String defaultValue) {
        return Optional.ofNullable(input).filter(StringUtils::isNotEmpty).orElse(defaultValue);
    }

    public static String getActualValue(String input) {
        return Optional.ofNullable(input).filter(StringUtils::isNotEmpty).orElse("-");
    }

    public static boolean isEmpty(String str) {
        return Optional.ofNullable(str).map(i -> i.length() == 0).orElse(true);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static <T> T nullGuard(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception ignored) {
            return null;
        }
    }

    public static void validate(String value, Predicate<String> predicate, final Supplier<String> supplier) {
        if (predicate.test(value)) {
            throw new IllegalArgumentException(supplier.get());
        }
    }

    public static boolean isString(final Object value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(NULL_STRING_MSG_SUPPLIER.get());
        }
        return value instanceof String;
    }

    public static byte[] getUTF8Bytes(String string) {
        return string == null ? null : string.getBytes(StandardCharsets.UTF_8);
    }

    public static String base64Decode(final String value) {
        validate(value, NULL_STRING_PREDICATE, NULL_STRING_MSG_SUPPLIER);
        return new String(Base64.getDecoder().decode(value), StandardCharsets.UTF_8);
    }

    public static String base64Encode(final String value) {
        validate(value, NULL_STRING_PREDICATE, NULL_STRING_MSG_SUPPLIER);
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }


    public static boolean equalsIgnoreCaseWithTrim(final String s1, final String s2) {
        if (s1 == null || s2 == null) {
            return s1 == s2;
        }
        return s1.trim().equalsIgnoreCase(s2.trim());
    }


    public static boolean areAnagram(String firstWord, String secondWord) {
        if (isEmpty(firstWord) || isEmpty(secondWord)) {
            return false;
        }

        firstWord = firstWord.replaceAll(" ", "").toLowerCase();
        secondWord = secondWord.replaceAll(" ", "").toLowerCase();

        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        return Arrays.equals(firstWord.chars().sorted().toArray(), secondWord.chars().sorted().toArray());
    }


}
