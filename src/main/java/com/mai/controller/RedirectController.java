package com.mai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {

    @RequestMapping(value = {"", "/", "welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String contacts() {
        return "contacts";
    }
}
