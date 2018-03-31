package com.mai.dto;

public class CalculationRequestDto {

    private String score;

    public CalculationRequestDto() {
    }

    private CalculationRequestDto(Builder builder) {
        setScore(builder.score);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CalculationRequestDto{" +
                "score='" + score + '\'' +
                '}';
    }


    public static final class Builder {
        private String score;

        private Builder() {
        }

        public Builder withScore(String val) {
            score = val;
            return this;
        }

        public CalculationRequestDto build() {
            return new CalculationRequestDto(this);
        }
    }
}
