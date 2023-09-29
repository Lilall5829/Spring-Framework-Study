package com.example.assign2.SubstringUniqueChar;

import org.springframework.stereotype.Service;

@Service
public class SubstringService {
    public boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }
}
