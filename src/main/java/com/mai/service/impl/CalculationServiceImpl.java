package com.mai.service.impl;

import com.mai.dto.CalculationRequestDto;
import com.mai.dto.CalculationResponseDto;
import com.mai.service.CalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOGGER = LogManager.getLogger(CalculationServiceImpl.class);

    private static final BigDecimal BETA_1 = BigDecimal.valueOf(225.4492);
    private static final BigDecimal BETA_2 = BigDecimal.valueOf(1.123609);

    @Override
    public CalculationResponseDto calculate(CalculationRequestDto calculationRequestDto) {

        if (calculationRequestDto == null || calculationRequestDto.getScore() == null) {
            return null;
        }

        Long val = Long.valueOf(calculationRequestDto.getScore());

        BigDecimal result = calculate(val);
        if (result == null) {
            return null;
        }

        return CalculationResponseDto.newBuilder()
                .withResult(String.valueOf(result.doubleValue()))
                .build();
    }

    private BigDecimal calculate(Long score) {

        final BigDecimal val = BigDecimal.valueOf(score);
        final BigDecimal power = BETA_1.subtract(BETA_2.multiply(val));

        final double exponent = Math.pow(Math.E, power.doubleValue());
        final BigDecimal divider = new BigDecimal(1 + exponent);

        return BigDecimal.valueOf(1).divide(divider, 10, RoundingMode.HALF_UP);
    }
}
