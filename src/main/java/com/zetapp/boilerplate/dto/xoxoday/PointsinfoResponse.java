package com.zetapp.boilerplate.dto.xoxoday;

import com.zetapp.boilerplate.model.PointsInfo;
import lombok.Data;

@Data
public class PointsinfoResponse {
	int status;
	PointsInfo pointsInfo;
}
