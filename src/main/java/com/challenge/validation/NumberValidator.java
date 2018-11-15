package com.challenge.validation;

public class NumberValidator {


    public boolean hasOnlyNumbers(String[] values) {

        for (int i = 0; i < values.length; i++) {

            if (!isNumeric(values[i]) ) {
                return false;
            }
        }

        return true;
    }


    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

}
