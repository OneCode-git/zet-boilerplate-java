package com.onecode.integrationservice.service;

import com.onecode.integrationservice.xoxoday.PointsinfoResponse;
import com.onecode.integrationservice.xoxoday.ProfileResponse;
import com.onecode.integrationservice.xoxoday.RefundRequest;
import com.onecode.integrationservice.xoxoday.UpdatePointsRequest;
import com.onecode.integrationservice.model.Customer;
import com.onecode.integrationservice.model.CustomerData;
import com.onecode.integrationservice.model.PointsInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class XoxodayService {

	public Customer customer;
	public XoxodayService() {
		customer = new Customer();
		customer.setId(1L);
		customer.setEmail("test@gmail.com");
		customer.setPhoneNumber("7024909038");
		customer.setTotalPoints(10000);
		customer.setPointsAvailable(10000);
	}


	public PointsinfoResponse getPoints(String id) {
		PointsinfoResponse pointsinfoResponse = new PointsinfoResponse();
		PointsInfo pointsInfo = new PointsInfo();
		pointsInfo.setPointsAvailable(customer.getPointsAvailable());
		pointsInfo.setPointsReceived(customer.getTotalPoints());
		pointsInfo.setPointsRedeemed(customer.getTotalPoints() - customer.getPointsAvailable());
		pointsinfoResponse.setPointsInfo(pointsInfo);
		return pointsinfoResponse;
	}

	public ProfileResponse getProfile(String uniqueId) {
		CustomerData customerData = new CustomerData();
		customerData.setEmail(customer.getEmail());
		customerData.setId(customer.getId());
		customerData.setPhoneNumber(customer.getPhoneNumber());
		ProfileResponse profileResponse = new ProfileResponse();
		profileResponse.setCustomerData(customerData);
		return profileResponse;
	}

	public void updatePoints(UpdatePointsRequest updatePointsRequest) {
		customer.setPointsAvailable(customer.getPointsAvailable() - updatePointsRequest.getTotalPointsRedeemed());
		customer.setTotalPoints(customer.getTotalPoints() + updatePointsRequest.getTotalPointsAdded());
	}

	public void refund(RefundRequest refundRequest) {
		customer.setPointsAvailable(customer.getPointsAvailable() + refundRequest.getRedemptionAmount());
	}
}
