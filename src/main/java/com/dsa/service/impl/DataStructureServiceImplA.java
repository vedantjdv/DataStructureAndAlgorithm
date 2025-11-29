package com.dsa.service.impl;

import org.springframework.stereotype.Service;

import com.dsa.service.DataStructureServiceA;

@Service
public class DataStructureServiceImplA implements DataStructureServiceA {

	Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

	@Override
	public String ping() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

	@Override
	public String linearSearch(Integer searchElement) throws Exception {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(searchElement)) {
				return "The element " + searchElement + " found at index " + (i + 1);
			}
		}
		return "The element " + searchElement + " has not been found in array.";
	}

	@Override
	public String binarySearch(Integer searchElement) throws Exception {
		Integer left = 0, right = array.length - 1;
		while (left <= right) {
			Integer mid = (left + right) / 2;
			if (array[mid].equals(searchElement)) {
				return "The element " + searchElement + " found at index " + (mid + 1);
			} else if (array[mid] < searchElement) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return "The element " + searchElement + " has not been found in array.";
	}

}
