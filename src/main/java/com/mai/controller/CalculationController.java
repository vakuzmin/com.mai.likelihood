package com.mai.controller;

import com.mai.dto.CalculationRequestDto;
import com.mai.dto.CalculationResponseDto;
import com.mai.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class CalculationController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @RequestMapping(value = {"", "/", "welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    // that is url that you access from the JSP
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(CalculationRequestDto calculationRequestDto, Map<String, Object> model, RedirectAttributes redirectAttributes) {

        try {

            CalculationResponseDto calculationResponseDto = calculationService.calculate(calculationRequestDto);
            if (calculationResponseDto == null) {

                redirectAttributes.addFlashAttribute("customerEmail", "Calculation error");
                return "redirect:welcome";
            }

            model.put("calculationResponse", calculationResponseDto);
            return "result";

        } catch (Throwable throwable) {

            redirectAttributes.addFlashAttribute("error", throwable.getMessage());
            return "redirect:welcome";
        }
    }
}
