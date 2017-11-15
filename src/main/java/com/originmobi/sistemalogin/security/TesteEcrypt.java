package com.originmobi.sistemalogin.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteEcrypt {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123"));

	}

}
