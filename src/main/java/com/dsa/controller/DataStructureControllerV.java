package com.dsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.constant.DsaAlgoConstants;
import com.dsa.dto.CommonResponse;
import com.dsa.service.DataStructureServiceA;
import com.dsa.service.DataStructureServiceV;

@RestController
@RequestMapping("/ds-v")
public class DataStructureControllerV {

	private static Logger logger = LoggerFactory.getLogger(DataStructureControllerA.class);
	
	@Autowired
	DataStructureServiceV dataStructureServiceV;
	
	@GetMapping("/v1/ping")
	public CommonResponse ping() throws Exception {
		logger.info("Entry in ping");
		
		CommonResponse commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceV.ping());
		
		logger.info("Entry in ping");
		return commonResponse;
	}

	@GetMapping("/sortingAlgo")
	public CommonResponse sortingAlgo(@RequestParam String sortingAlgo,@RequestParam int[] arr) throws Exception {
		logger.info("Entry in sortingAlgo");
		CommonResponse commonResponse= null;
		switch (sortingAlgo) {
			case "bubbleSort":
				commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceV.bubbleSort(arr));				
				break;
			case "selectionSort":
				commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceV.selectionSort(arr));
				break;
			case "mergeSort":
				commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceV.mergeSort(arr));
				break;
			case "quickSort":
				commonResponse = new CommonResponse(HttpStatus.OK.value(), DsaAlgoConstants.SUCCESS, dataStructureServiceV.quickSort(arr));
			default:
				break;
		}
		logger.info("Exit from sortingAlgo");	
		return commonResponse;
	}
}
