package com.mai.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Coefficients implements Serializable {

    private BigDecimal beta1;

    private BigDecimal beta2;

    public Coefficients() {
    }

    private Coefficients(Builder builder) {
        setBeta1(builder.beta1);
        setBeta2(builder.beta2);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public BigDecimal getBeta1() {
        return beta1;
    }

    public void setBeta1(BigDecimal beta1) {
        this.beta1 = beta1;
    }

    public BigDecimal getBeta2() {
        return beta2;
    }

    public void setBeta2(BigDecimal beta2) {
        this.beta2 = beta2;
    }


    public static final class Builder {
        private BigDecimal beta1;
        private BigDecimal beta2;

        private Builder() {
        }

        public Builder withBeta1(BigDecimal val) {
            beta1 = val;
            return this;
        }

        public Builder withBeta2(BigDecimal val) {
            beta2 = val;
            return this;
        }

        public Coefficients build() {
            return new Coefficients(this);
        }
    }
}
