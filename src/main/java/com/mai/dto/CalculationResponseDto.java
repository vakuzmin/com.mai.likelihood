package com.mai.dto;

public class CalculationResponseDto {

    private String result;

    public CalculationResponseDto() {
    }

    private CalculationResponseDto(Builder builder) {
        setResult(builder.result);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalculationResponseDto{" +
                "result='" + result + '\'' +
                '}';
    }

    public static final class Builder {
        private String result;

        private Builder() {
        }

        public Builder withResult(String val) {
            result = val;
            return this;
        }

        public CalculationResponseDto build() {
            return new CalculationResponseDto(this);
        }
    }
}
