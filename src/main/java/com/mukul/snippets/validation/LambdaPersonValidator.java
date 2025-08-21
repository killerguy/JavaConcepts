package com.mukul.snippets.validation;

import com.mukul.snippets.validation.funcInterface.Validation;

import static com.mukul.snippets.validation.helper.IntegerValidationHelpers.intBetween;
import static com.mukul.snippets.validation.helper.StringValidationHelpers.*;

public class LambdaPersonValidator implements PersonValidator {

    public void validate(Person person) {
        notNull.and(between(2, 12)).test(person.getFirstName()).throwIfInvalid("firstName");
        notNull.and(between(4, 30)).test(person.getLastName()).throwIfInvalid("secondName");
        notNull.and(between(3, 50)).and(contains("@")).test(person.getEmail()).throwIfInvalid("email");
        intBetween(0, 110).test(person.getAge()).throwIfInvalid("age");
    }

    public static void main(String[] args) {
        LambdaPersonValidator validator = new LambdaPersonValidator();
        Person person = new Person("John", "Does", "john.doe@abc.com", 30);
        try {
            //validator.validate(person);
            validator.validate1(person);
            System.out.println("Person is valid");
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }



    public void validate1(Person person) {
        validateField(person.getFirstName(), notNull.and(between(2, 12)), "firstName");
        validateField(person.getLastName(), notNull.and(between(4, 30)), "secondName");
        validateField(person.getEmail(), notNull.and(between(3, 50)).and(contains("@")), "email");
        validateField(person.getAge(), intBetween(0, 110), "age");
    }

    private <T> void validateField(T value, Validation<T> validator, String fieldName) {
        validator.test(value).throwIfInvalid(fieldName);
    }


}