package com.zetapp.boilerplate.dto.xoxoday;

import lombok.Data;

@Data
public class UpdatePointsRequest {
	private String uniqueId;
	private String authToken;
	private int totalPointsRedeemed;
	private int totalPointsAdded;
	private String orderId;
	private String comments;
}
