package com.mai.service;

import com.mai.dto.HelloRequestDto;
import com.mai.dto.HelloResponseDto;

public interface LikelihoodService {

    HelloResponseDto calculate(HelloRequestDto helloRequestDto);
}
