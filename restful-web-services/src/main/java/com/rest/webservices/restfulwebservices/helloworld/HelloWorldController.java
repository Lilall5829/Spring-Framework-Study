package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
    //hello-world
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//    public String helloworld(){
//        return "Hello World";
//    }
    //A better way
    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "Hello World";
    }
    @GetMapping(path = "/hello-world")
    public String helloworldBean(){
        return new HelloWorldBean("Hello World");
    }

}
