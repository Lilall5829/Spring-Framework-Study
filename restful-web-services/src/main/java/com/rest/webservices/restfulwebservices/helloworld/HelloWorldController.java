package com.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//REST API
@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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
    @GetMapping(path = "/hello-world-Bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("Hello World");
    }
    // I want to pass "lila" to the path variable "name"
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloworldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }
// Internationalized
    @GetMapping(path = "/hello-world-internationalized")
    public String helloworldInternationalized(){
        //Get the locale
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,"Default Message", locale);
//        return "Hello World";
    }

}
