package com.dsa.service.impl;

import org.springframework.stereotype.Service;

import com.dsa.service.AlgorithmServiceA;

@Service
public class AlgorithServiceImplA implements AlgorithmServiceA {

	private Integer[] array = {1, 3 ,5, 7, 9, 2, 8, 4, 6};
	
	@Override
	public String ping() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

	@Override
	public String setArray(Integer[] array) throws Exception {
		this.array = array;
		return getArray();
	}

	@Override
	public String getArray() throws Exception {
		String response = "";
		if (array == null) {
			return "Opps, array is empty..!!!";
		}
		for (int i = 0; i < array.length - 1; i++) {
			response += array[i] + "-->";
		}
		response += array[array.length - 1];
		return response;
	}

	@Override
	public String bubbleSort() throws Exception {
		if (array == null) {
			return "Opps, array is empty..!!!";
		}
		for (int i = 0; i < array.length; i++) {
			boolean isArraySorted = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					isArraySorted = false;
				}
			}
			if (isArraySorted) {
				return "array sorted..!!!\n" + getArray();
			}
		}
		return "array sorted..!!!\n" + getArray();
	}

	@Override
	public String selectionSort() throws Exception {
		if (array == null) {
			return "Opps, array is empty..!!!";
		}
		for (int i = 0; i < array.length - 1; i++) {
			int minElementIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minElementIndex] > array[j]) {
					minElementIndex = j;
				}
			}
			if (minElementIndex != i) {
				int temp = array[minElementIndex];
				array[minElementIndex] = array[i];
				array[i] = temp;
			}
		}
		return "array sorted..!!\n" + getArray();
	}
}
