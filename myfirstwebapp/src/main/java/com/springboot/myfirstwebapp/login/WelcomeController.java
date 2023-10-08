package com.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//    private AuthenticationService authenticationService;
//    Initialize authenticationService
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    //Get request for going to login page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    //Post request for going to welcome page
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    //How to catch the username and password? Use @RequestParam, and map it to welcome page by ModelMap
//    public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if (authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            model.put("password", password);
//            return "welcome";
//        }
//        else {
//            model.put("errorMessage","Invalid Credentials");
//            return "login";}
//
//    }
    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
