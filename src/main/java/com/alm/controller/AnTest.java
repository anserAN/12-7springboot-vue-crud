package com.alm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
public class AnTest {
    @RequestMapping("/jsp")
    public String testJsp() {
        System.out.println("asdfasaaaaa");
        return "an";
    }
}
