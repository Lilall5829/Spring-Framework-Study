package com.example.assign2.Palindrome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PalindromeController {
    private PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @RequestMapping(value = "palindrome-checker", method = RequestMethod.GET)
    public String palindrome() {
        return "palindromeChecker";
    }

    @RequestMapping(value = "palindrome-checker", method = RequestMethod.POST)
    public String result(@RequestParam String palindrome, ModelMap model) {
        if (palindromeService.isPalindrome(palindrome)) {
            model.put("result", palindrome + " is a palindrome!");
        } else {
            model.put("result", palindrome + " is NOT a palindrome!");
        }
        return "palindromeChecker";
    }
}
