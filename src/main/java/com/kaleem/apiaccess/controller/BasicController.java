package com.kaleem.apiaccess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/somePage")
    @ResponseBody
    public String somePage() {
        return "Some other Page has been accessed !!";
    }
}
