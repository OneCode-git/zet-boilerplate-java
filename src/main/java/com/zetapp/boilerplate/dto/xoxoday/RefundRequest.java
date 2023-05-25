package com.zetapp.boilerplate.dto.xoxoday;

import lombok.Data;

@Data
public class RefundRequest {
	private String uniqueId;
	private String authToken;
	private String transactionId;
	private int redemptionAmount;
	private String comments;
}
