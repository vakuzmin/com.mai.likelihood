package com.mai.service.impl;

import com.mai.dto.CalculationRequestDto;
import com.mai.dto.CalculationResponseDto;
import com.mai.dto.Coefficients;
import com.mai.service.CalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculationServiceImpl implements CalculationService {

    private static final Logger LOGGER = LogManager.getLogger(CalculationServiceImpl.class);

    private final Map<String, Coefficients> coefficientsMap = new HashMap<>();

    @PostConstruct
    public void initialize() {

        coefficientsMap.put("calculate",
                Coefficients.newBuilder()
                        .withBeta1(BigDecimal.valueOf(225.4492))
                        .withBeta2(BigDecimal.valueOf(1.123609))
                        .build());

        coefficientsMap.put("calculate2",
                Coefficients.newBuilder()
                        .withBeta1(BigDecimal.valueOf(1.52 * Math.pow(Math.E, -51)))
                        .withBeta2(BigDecimal.valueOf(1.751805))
                        .build());
    }

    @Override
    public CalculationResponseDto calculate(CalculationRequestDto calculationRequestDto) {

        if (calculationRequestDto == null || calculationRequestDto.getScore() == null) {
            return null;
        }

        Long val = Long.valueOf(calculationRequestDto.getScore());
        Coefficients coefficients = coefficientsMap.get(calculationRequestDto.getClicked());

        BigDecimal result = calculate(val, coefficients.getBeta1(), coefficients.getBeta2());
        if (result == null) {
            return null;
        }

        return CalculationResponseDto.newBuilder()
                .withResult(String.valueOf(result.doubleValue() * 100))
                .build();
    }

    // формула
    private BigDecimal calculate(Long score, BigDecimal beta1, BigDecimal beta2) {

        // BigDecimal  выполняет операции с такими же BigDecimal объектами, поэтому сначала ты приводишь число к BigDecimal типу
        final BigDecimal val = BigDecimal.valueOf(score);

        // высчитываем стпень в которую мы будем возводить, subtract операция вычитания; multiply умножения
        final BigDecimal power = beta1.subtract(beta2.multiply(val));

        // возводим экспоненту в степень power путем обратного приведения BigDecimal к doubleValue числу
        final double exponent = Math.pow(Math.E, power.doubleValue());

        // добавляем единицу к получившемуся числу
        final BigDecimal divider = new BigDecimal(1 + exponent);

        // делим 1 на делитель выше оставляя 10 знаков после запятой с округлением в большую сторону
        return BigDecimal.valueOf(1).divide(divider, 5, RoundingMode.HALF_UP);
    }
}

