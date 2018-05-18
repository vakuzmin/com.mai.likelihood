package com.mai.service;

import com.mai.dto.CalculationRequestDto;
import com.mai.dto.CalculationResponseDto;

public interface CalculationService {

    CalculationResponseDto calculate(CalculationRequestDto calculationRequestDto);
}
public interface CalculationService2 {

    CalculationResponseDto calculate2(CalculationRequestDto calculationRequestDto);
}