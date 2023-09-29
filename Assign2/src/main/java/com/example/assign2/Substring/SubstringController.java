package com.example.assign2.Substring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubstringController {
    public SubstringService substringService;

    public SubstringController(SubstringService substringService) {
        this.substringService = substringService;
    }

    @RequestMapping(value = "substring", method = RequestMethod.GET)
    public String substring() {
        return "substring";
    }

    @RequestMapping(value = "substring", method = RequestMethod.POST)
    public String output(@RequestParam String s1, String s2, ModelMap model) {
        if (substringService.isSubstring(s1, s2)) {
            model.put("output", s2 + " is a substring of " + s1);
        } else {
            model.put("output", s2 + " is NOT a substring of " + s1);
        }

        return "substring";

    }
}