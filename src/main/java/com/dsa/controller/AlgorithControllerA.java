package com.dsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.constant.DsaAlgoConstants;
import com.dsa.dto.CommonResponse;
import com.dsa.service.AlgorithmServiceA;

@RestController
@RequestMapping("/al-v")
public class AlgorithControllerA {

	private static Logger logger = LoggerFactory.getLogger(DataStructureControllerA.class);
	
	@Autowired
	AlgorithmServiceA algorithmServiceA;
	
	@GetMapping("/v1/ping")
	public CommonResponse ping() throws Exception {
		logger.info("Entry in ping");
		
		CommonResponse commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.ping());
		
		logger.info("Entry in ping");
		return commonResponse;
	}
	
	/**************************************************************************************************
	 * ARRAY GETTING AND SETTING
	 **************************************************************************************************/
	
	@PostMapping("/setArray")
	public CommonResponse setArray(@RequestParam(value = "array") Integer[] array) {
		logger.info("entry from setArray");
		
		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.setArray(array));
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from setArray");
		return commonResponse;
	}

	@GetMapping("/getArray")
	public CommonResponse getArray() {
		logger.info("entry in getArray");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.getArray());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from getArray");
		return commonResponse;
	}	
	
	/**************************************************************************************************
	 * SORTING DATA STRUCTURE 
	 **************************************************************************************************/
	
	@GetMapping("/bubble-sort")
	public CommonResponse bubbleSort() {
		logger.info("entry in bubbleSort");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.bubbleSort());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from bubbleSort");
		return commonResponse;
	}

	@GetMapping("/selection-sort")
	public CommonResponse selectionSort() {
		logger.info("entry in selectionSort");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.selectionSort());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from selectionSort");
		return commonResponse;
	}

	@GetMapping("/insertion-sort")
	public CommonResponse insertionSort() {
		logger.info("entry in insertionSort");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.insertionSort());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from insertionSort");
		return commonResponse;
	}
	
	@GetMapping("/merge-sort")
	public CommonResponse mergeSort() {
		logger.info("entry in mergeSort");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.mergeSort());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from mergeSort");
		return commonResponse;
	}
	
	@GetMapping("/quick-sort")
	public CommonResponse quickSort() {
		logger.info("entry in quickSort");

		CommonResponse commonResponse = null;
		try {
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, algorithmServiceA.quickSort());
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, e.getMessage());
		}
		logger.info("exit from quickSort");
		return commonResponse;
	}
}
