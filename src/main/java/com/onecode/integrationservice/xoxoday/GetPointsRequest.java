package com.onecode.integrationservice.xoxoday;

import lombok.Data;

@Data
public class GetPointsRequest {
	private String uniqueId;
	private String authToken;
}
