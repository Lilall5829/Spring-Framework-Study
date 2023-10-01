package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    //Initialize authenticationService


    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //Get request for going to login page
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //Post request for going to welcome page
    @RequestMapping(value = "login", method = RequestMethod.POST)
    //How to catch the username and password? Use @RequestParam, and map it to welcome page by ModelMap
    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
        else {
            model.put("errorMessage","Invalid Credentials");
            return "login";}

    }
}
