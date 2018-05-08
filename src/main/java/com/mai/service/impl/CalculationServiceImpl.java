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

        // BigDecimal  выполняет операции с такими же BigDecimal объектами, поэтому сначала ты приводишь число к BigDecimal типу
        final BigDecimal val = BigDecimal.valueOf(score);

        // высчитываем стпень в которую мы будем возводить, subtract операция вычитания; multiply умножения
        final BigDecimal power = BETA_1.subtract(BETA_2.multiply(val));

        // возводим экспоненту в степень power путем обратного приведения BigDecimal к doubleValue числу
        final double exponent = Math.pow(Math.E, power.doubleValue());

        // добавляем единицу к получившемуся числу
        final BigDecimal divider = new BigDecimal(1 + exponent);

        // делим 1 на делитель выше оставляя 10 знаков после запятой с округлением в большую сторону
        return BigDecimal.valueOf(1).divide(divider, 10, RoundingMode.HALF_UP);
    }
}
