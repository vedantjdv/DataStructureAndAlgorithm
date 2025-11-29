package com.dsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.constant.DsaAlgoConstants;
import com.dsa.dto.CommonResponse;
import com.dsa.service.DataStructureServiceA;


@RestController
@RequestMapping("/ds-a")
public class DataStructureControllerA {

	private static Logger logger = LoggerFactory.getLogger(DataStructureControllerA.class);
	
	@Autowired
	DataStructureServiceA dataStructureServiceA;
	
	@GetMapping("/v1/ping")
	public CommonResponse ping() throws Exception {
		logger.info("Entry in ping");
		
		CommonResponse commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceA.ping());
		
		logger.info("Entry in ping");
		return commonResponse;
	}
	
	@GetMapping("/linear-search")
	public CommonResponse linearSearch(@Validated @RequestParam("searchElement") Integer searchElement) {
		logger.info("entry in linearSearch");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceA.linearSearch(searchElement));
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from linearSearch");
		return commonResponse;
	}
	
	@GetMapping("/binary-search")
	public CommonResponse binarySearch(@Validated @RequestParam("searchElement") Integer searchElement) {
		logger.info("entry in binarySearch");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceA.binarySearch(searchElement));
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from binarySearch");
		return commonResponse;
	}
}
