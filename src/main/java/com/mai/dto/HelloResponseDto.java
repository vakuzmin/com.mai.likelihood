package com.mai.dto;

public class HelloResponseDto {

    private String message;

    public HelloResponseDto() {
    }

    private HelloResponseDto(Builder builder) {
        setMessage(builder.message);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static final class Builder {
        private String message;

        private Builder() {
        }

        public Builder withMessage(String val) {
            message = val;
            return this;
        }

        public HelloResponseDto build() {
            return new HelloResponseDto(this);
        }
    }
}
