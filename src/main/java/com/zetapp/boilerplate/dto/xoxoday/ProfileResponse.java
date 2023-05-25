package com.zetapp.boilerplate.dto.xoxoday;

import com.zetapp.boilerplate.model.CustomerData;
import lombok.Data;

@Data
public class ProfileResponse {
	private int status;
	private String message;
	CustomerData customerData;
}
