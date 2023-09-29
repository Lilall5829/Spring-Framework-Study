package com.example.assign2.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLEncoderController {
    private URLEncoderService urlEncoderService;

    public URLEncoderController(URLEncoderService urlEncoderService) {
        this.urlEncoderService = urlEncoderService;
    }
    @RequestMapping(value = "ascii", method = RequestMethod.GET)
    public String urlCoder() {
        return "URLEncoder";
    }

    @RequestMapping(value = "ascii", method = RequestMethod.POST)
    public String result(@RequestParam String url, ModelMap model) {
        String output = urlEncoderService.encodeURL(url);
            model.put("output", output);
        return "URLEncoder";
    }
}
