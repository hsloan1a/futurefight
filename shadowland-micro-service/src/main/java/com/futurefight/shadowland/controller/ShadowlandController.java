package com.futurefight.shadowland.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShadowlandController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
