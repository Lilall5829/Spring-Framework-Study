package com.example.assign2.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class URLEncoderService {
    public String encodeURL(String input){
        return input.replaceAll(" ", "%20");
    }
}
