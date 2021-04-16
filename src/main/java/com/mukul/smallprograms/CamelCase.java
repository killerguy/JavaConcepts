package com.mukul.smallprograms;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import static java.util.stream.Collectors.*;

public class CamelCase {

    private static final Predicate<String> NULL_STRING_PREDICATE = Objects::isNull;
    private static final Supplier<String> NULL_STRING_MSG_SUPPLIER = () -> "'value' should be not null.";

    public static String toCamelCase(final String value) {
        if (value == null || value.length() == 0) {
            return "";
        }
        String str = toStudlyCase(value);
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String toStudlyCase(final String value) {
        validate(value);
        String[] words = collapseWhitespace(value.trim()).split("\\s*(_|-|\\s)\\s*");
        return Arrays.stream(words).filter(w -> !w.trim().isEmpty()).map(CamelCase::upperFirst).collect(joining());
    }

    public static String collapseWhitespace(final String value) {
        validate(value);
        return value.trim().replaceAll("\\s\\s+", " ");
    }

    private static void validate(String value) {
        if (CamelCase.NULL_STRING_PREDICATE.test(value)) {
            throw new IllegalArgumentException(CamelCase.NULL_STRING_MSG_SUPPLIER.get());
        }
    }

    public static String upperFirst(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input can't be null");
        }
        return head(input).map(String::toUpperCase).map(h -> tail(input).map(t -> h + t).orElse(h)).get();
    }

    public static Optional<String> head(final String value) {
        return first(value, 1);
    }

    public static Optional<String> first(final String value, final int n) {
        return Optional.ofNullable(value).filter(v -> !v.isEmpty()).map(v -> v.substring(0, n));
    }

    public static Optional<String> tail(final String value) {
        return Optional.ofNullable(value).filter(v -> !v.isEmpty()).map(v -> last(v, v.length() - 1));
    }
    public static String last(final String value, int n) {
        validate(value);
        if (n > value.length()) {
            return value;
        }
        return value.substring(value.length() - n);
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase("Purchase controller"));
    }

}
