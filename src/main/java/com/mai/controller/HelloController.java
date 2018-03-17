package com.mai.controller;

import com.mai.dto.HelloRequestDto;
import com.mai.dto.HelloResponseDto;
import com.mai.service.LikelihoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HelloController {

    @Value("${welcome.message}")
    private String message;

    private final LikelihoodService likelihoodService;

    @Autowired
    public HelloController(LikelihoodService likelihoodService) {
        this.likelihoodService = likelihoodService;
    }

    @RequestMapping(value = {"", "/", "welcome"}, method = RequestMethod.GET)
    public String welcome(Map<String, Object> model) {

        // that's the model where you should put the results to have access to them from your JSP file
        model.put("message", message);

        // that's jsp name to redirect to
        return "welcome";
    }

    // that is url that you access from the JSP
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(HelloRequestDto helloRequestDto, Map<String, Object> model) {

        HelloResponseDto helloResponseDto = likelihoodService.calculate(helloRequestDto);

        model.put("helloResponseDto", helloResponseDto);
        return "result";
    }
}
