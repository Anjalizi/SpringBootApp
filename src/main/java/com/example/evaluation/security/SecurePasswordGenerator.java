package com.example.evaluation.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurePasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);
         
        System.out.println(encodedPassword);
	}
}
