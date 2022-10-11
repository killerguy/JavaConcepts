package com.mukul.snippets.validation;

public class LambdaPersonValidatorTest extends AbstractPersonValidationsTest {
    @Override
    protected PersonValidator getValidatorInstance() {
        return new LambdaPersonValidator();
    }
}
