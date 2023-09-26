package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody//This annotation will return the following code directly, such as a string
    public String sayHello(){
        return "Hello!";
    }

    //JSP
    @RequestMapping("say-hello-jsp")
//    @ResponseBody
    public String sayHelloJsp(){
        return "sayHello";
    }
}
