package com.zetapp.boilerplate.controller;

import com.zetapp.boilerplate.dto.xoxoday.*;
import com.zetapp.boilerplate.model.Customer;
import com.zetapp.boilerplate.service.XoxodayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/xoxoday")
public class XoxodayController {

	@Autowired
	XoxodayService xoxodayService;

	@PostMapping("/points")
	public ResponseEntity<PointsinfoResponse> getPoints(@RequestBody GetPointsRequest getPointsRequest) {
		PointsinfoResponse pointsinfoResponse = xoxodayService.getPoints(getPointsRequest.getUniqueId());
		pointsinfoResponse.setStatus(1);
		return ResponseEntity.ok(pointsinfoResponse);
	}

	@PostMapping("/profile")
	public ResponseEntity<ProfileResponse> getProfile(@RequestBody GetPointsRequest getPointsRequest) {
		ProfileResponse profileResponse = xoxodayService.getProfile(getPointsRequest.getUniqueId());
		profileResponse.setStatus(1);
		return ResponseEntity.ok(profileResponse);
	}

	@PutMapping("/points")
	public ResponseEntity<XoxoDayResponse> updatePoints(@RequestBody UpdatePointsRequest updatePointsRequest) {
		xoxodayService.updatePoints(updatePointsRequest);
		XoxoDayResponse xoxoDayResponse = new XoxoDayResponse();
		xoxoDayResponse.setStatus(1);
		return ResponseEntity.ok(xoxoDayResponse);
	}

	@PostMapping("/refund")
	public ResponseEntity<XoxoDayResponse> refund(@RequestBody RefundRequest refundRequest) {
		xoxodayService.refund(refundRequest);
		XoxoDayResponse xoxoDayResponse = new XoxoDayResponse();
		xoxoDayResponse.setStatus(1);
		return ResponseEntity.ok(xoxoDayResponse);
	}
}
