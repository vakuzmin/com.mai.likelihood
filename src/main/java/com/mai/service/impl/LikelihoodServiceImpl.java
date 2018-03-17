package com.mai.service.impl;

import com.mai.dto.HelloRequestDto;
import com.mai.dto.HelloResponseDto;
import com.mai.service.LikelihoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LikelihoodServiceImpl implements LikelihoodService {

    private static final Logger LOGGER = LogManager.getLogger(LikelihoodServiceImpl.class);

    @Override
    public HelloResponseDto calculate(HelloRequestDto helloRequestDto) {

        if (helloRequestDto == null) {
            return null;
        }

        String val1 = helloRequestDto.getVal1();
        String val2 = helloRequestDto.getVal2();

        try {

            Long long1 = Long.valueOf(val1);
            Long long2 = Long.valueOf(val2);

            return HelloResponseDto.newBuilder()
                    .withMessage(String.valueOf(long1 + long2))
                    .build();

        } catch (Throwable throwable) {

            LOGGER.error("Values must be numeric");

            return HelloResponseDto.newBuilder()
                    .withMessage("Values must be numeric")
                    .build();
        }
    }
}
