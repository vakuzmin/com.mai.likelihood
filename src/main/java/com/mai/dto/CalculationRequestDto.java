package com.mai.dto;

public class CalculationRequestDto {

    private String score;

    private String clicked;

    public CalculationRequestDto() {
    }

    private CalculationRequestDto(Builder builder) {
        setScore(builder.score);
        setClicked(builder.clicked);
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

    public String getClicked() {
        return clicked;
    }

    public void setClicked(String clicked) {
        this.clicked = clicked;
    }

    @Override
    public String toString() {
        return "CalculationRequestDto{" +
                "score='" + score + '\'' +
                '}';
    }


    public static final class Builder {
        private String score;
        private String clicked;

        private Builder() {
        }

        public Builder withScore(String val) {
            score = val;
            return this;
        }

        public Builder withClicked(String val) {
            clicked = val;
            return this;
        }

        public CalculationRequestDto build() {
            return new CalculationRequestDto(this);
        }
    }
}
