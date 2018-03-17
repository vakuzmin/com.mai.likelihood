package com.mai.dto;

public class HelloRequestDto {

    private String val1;

    private String val2;

    public HelloRequestDto() {
    }

    private HelloRequestDto(Builder builder) {
        setVal1(builder.val1);
        setVal2(builder.val2);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }


    public static final class Builder {
        private String val1;
        private String val2;

        private Builder() {
        }

        public Builder withVal1(String val) {
            val1 = val;
            return this;
        }

        public Builder withVal2(String val) {
            val2 = val;
            return this;
        }

        public HelloRequestDto build() {
            return new HelloRequestDto(this);
        }
    }
}
