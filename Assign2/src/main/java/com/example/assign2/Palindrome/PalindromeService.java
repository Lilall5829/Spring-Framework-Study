package com.example.assign2.Palindrome;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public boolean isPalindrome(String input) {
        // Remove spaces and convert to lowercase for a case-insensitive comparison
        String cleanedInput = input.replaceAll("\\s", "").toLowerCase();
        int length = cleanedInput.length();

        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
