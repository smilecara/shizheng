package com.rua.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author One
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class DemoController {

    @Value(value = "${message}")
    private String message;

    @Value(value = "${user.name}")
    private String name;

    @RequestMapping(value = "/demo", method = GET)
    public String demo() {
        return "hello demo";
    }

    @RequestMapping(value = "/hello", method = GET)
    public String get() {
        return "hello," + message;
    }

    @RequestMapping(value = "/name", method = GET)
    public String name() {
        return "hello, " + name + "message, " + message;
    }
}