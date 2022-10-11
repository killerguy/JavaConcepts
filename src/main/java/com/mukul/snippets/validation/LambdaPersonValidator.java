package com.mukul.snippets.validation;

import static com.mukul.snippets.validation.helper.IntegerValidationHelpers.intBetween;
import static com.mukul.snippets.validation.helper.StringValidationHelpers.*;

public class LambdaPersonValidator implements PersonValidator {

    public void validate(Person person) {
        notNull.and(between(2, 12)).test(person.getFirstName()).throwIfInvalid("firstName");
        notNull.and(between(4, 30)).test(person.getLastName()).throwIfInvalid("secondName");
        notNull.and(between(3, 50)).and(contains("@")).test(person.getEmail()).throwIfInvalid("email");
        intBetween(0, 110).test(person.getAge()).throwIfInvalid("age");
    }

}