package com.mai.service;

import com.mai.dto.CalculationRequestDto;
import com.mai.dto.CalculationResponseDto;

public interface CalculationService {

    CalculationResponseDto calculate(CalculationRequestDto calculationRequestDto);
}