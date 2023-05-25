package com.onecode.integrationservice.xoxoday;

import com.onecode.integrationservice.model.CustomerData;
import lombok.Data;

@Data
public class ProfileResponse {
	private int status;
	private String message;
	CustomerData customerData;
}
