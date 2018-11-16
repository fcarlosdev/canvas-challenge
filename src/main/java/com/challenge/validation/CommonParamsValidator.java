package com.challenge.validation;

import java.util.Arrays;

public abstract class CommonParamsValidator implements ParametersValidator {

    private int to;
    private int from;
    private int numberOfParams;
    private NumberValidator numberValidator  = new NumberValidator();

    @Override
    public boolean validateParameters(String... params) {
        return numberOfParamvalid(params) && dimensionsValid(params) && dimensionsValid(params);
    }

    private boolean numberOfParamvalid(String ...params) {
        return  ( params.length > numberOfParams || params.length < numberOfParams) ? false : true;
    }

    private boolean dimensionsValid(String ...params) {
        return numberValidator.hasOnlyNumbers(Arrays.copyOfRange(params,from,to));
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setNumberOfParams(int numberOfParams) {
        this.numberOfParams = numberOfParams;
    }


}
