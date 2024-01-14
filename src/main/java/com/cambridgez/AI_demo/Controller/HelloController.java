package com.cambridgez.AI_demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET) // http://localhost:8080/hello
    @ResponseBody   //返回json格式的数据
    public String  Hello(){
        return "Hello World";
    }
}
