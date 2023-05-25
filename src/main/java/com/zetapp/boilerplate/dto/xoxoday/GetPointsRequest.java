package com.zetapp.boilerplate.dto.xoxoday;

import lombok.Data;

@Data
public class GetPointsRequest {
	private String uniqueId;
	private String authToken;
}
