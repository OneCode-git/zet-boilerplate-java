package com.zetapp.boilerplate.model;

import lombok.Data;

@Data
public class Customer {
	private Long id;
	private String email;
	private String phoneNumber;
	private int totalPoints;
	private int pointsAvailable;
}
