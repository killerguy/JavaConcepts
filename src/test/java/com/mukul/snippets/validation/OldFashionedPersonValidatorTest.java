package com.mukul.snippets.validation;

public class OldFashionedPersonValidatorTest extends AbstractPersonValidationsTest {
    @Override
    protected PersonValidator getValidatorInstance() {
        return new OldFashionedPersonValidator();
    }

}