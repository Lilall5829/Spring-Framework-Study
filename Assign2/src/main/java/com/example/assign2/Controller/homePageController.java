package com.example.assign2.Controller;
import com.example.assign2.Palindrome.PalindromeService;
import com.example.assign2.Substring.SubstringService;
import com.example.assign2.SubstringUniqueChar.SubstringUCService;
import com.example.assign2.TransposeMatrix.MatrixTransposeService;
import com.example.assign2.URLEncoder.URLEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class homePageController {
    @Autowired
    private PalindromeService palindromeService;
    public SubstringService substringService;
    public SubstringUCService substringUCService;
    public MatrixTransposeService matrixTransposeService;
    private URLEncoderService urlEncoderService;

    public homePageController(PalindromeService palindromeService, SubstringService substringService, SubstringUCService substringUCService, MatrixTransposeService matrixTransposeService, URLEncoderService urlEncoderService) {
        this.palindromeService = palindromeService;
        this.substringService = substringService;
        this.substringUCService = substringUCService;
        this.matrixTransposeService = matrixTransposeService;
        this.urlEncoderService = urlEncoderService;
    }

    @RequestMapping(value = "/palindrome", method = RequestMethod.GET)
    public String palindrome() {
        return "homepage";
    }

    @RequestMapping(value = "/palindrome", method = RequestMethod.POST)
    public String result1(@RequestParam String palindrome, ModelMap model) {
        if (palindromeService.isPalindrome(palindrome)) {
            model.put("palindrome", palindrome + " is a palindrome!");
        } else {
            model.put("palindrome", palindrome + " is NOT a palindrome!");
        }
        return "homepage";
    }

    @RequestMapping(value = "/substring", method = RequestMethod.GET)
    public String substring() {
        return "homepage";
    }

    @RequestMapping(value = "/substring", method = RequestMethod.POST)
    public String result2(@RequestParam String s1, String s2, ModelMap model) {
        if (substringService.isSubstring(s1, s2)) {
            model.put("substring", s2 + " is a substring of " + s1);
        } else {
            model.put("substring", s2 + " is NOT a substring of " + s1);
        }
        return "homepage";
    }

    @RequestMapping(value = "/substringUC", method = RequestMethod.GET)
    public String substringUC() {
        return "homepage";
    }

    @RequestMapping(value = "/substringUC", method = RequestMethod.POST)
    public String result3(@RequestParam String suc1, String suc2, ModelMap model) {
        if (substringUCService.isSubstring(suc1, suc2)) {
            model.put("substringUC", suc1 + " contains " + suc2);
        } else {
            model.put("substringUC", suc1 + " doesn't contain " + suc2);
        }

        return "homepage";
    }

    @RequestMapping(value = "/transpose", method = RequestMethod.GET)
    public String tranpose() {
        return "homepage";
    }

    @RequestMapping(value = "/transpose", method = RequestMethod.POST)
    public String result4(@RequestParam String matrix00, String matrix01, String matrix10, String matrix11, ModelMap model) {
        int[][] matrix = matrixTransposeService.toMatrix(matrix00, matrix01, matrix10, matrix11);
        matrix = matrixTransposeService.transposeMatrix(matrix);
        model.put("matrix00", matrix[0][0]);
        model.put("matrix01", matrix[0][1]);
        model.put("matrix10", matrix[1][0]);
        model.put("matrix11", matrix[1][1]);
        return "homepage";

    }

    @RequestMapping(value = "/ascii", method = RequestMethod.GET)
    public String urlCoder() {
        return "homepage";
    }

    @RequestMapping(value = "/ascii", method = RequestMethod.POST)
    public String result5(@RequestParam String url, ModelMap model) {
        String output = urlEncoderService.encodeURL(url);
        model.put("urlEncoder", output);
        return "homepage";
    }
}
