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

//	Time complexity - O(n^2)
//	Space complexity - O(1)
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

//	Time complexity - O(n^2)
//	Space complexity - O(1)
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

//	Time complexity - O(n^2)
//	Space complexity - O(1)
	@Override
	public String insertionSort() throws Exception {
		if (array == null) {
			return "Opps, array is empty..!!!";
		}
		for (int i = 1; i < array.length - 1; i++) {
			for (int j = i; j > 0 && array[j+1] < array[j]; j--) {
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
		}
		return "array sorted..!!\n" + getArray();
	}

//	Time complexity - O(n log(n))
//	Space complexity - O(n)
//	extremely fast than other sorting, highly preferable for large data set, stable and fastest.
	@Override
	public String mergeSort() throws Exception {
		mergeSortMain(array);
		return "array sorted..!!\n" + getArray();
	}
	
	public void mergeSortMain(Integer[] arr) throws Exception {
		if (arr.length <= 1) {
			return;
		}
		Integer mid = arr.length/2;
		Integer[] left = new Integer[mid];
		Integer[] right = new Integer[arr.length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for (int i = mid; i < arr.length; i++) {
			right[i-mid]=arr[i];
		}
		mergeSortMain(left);
		mergeSortMain(right);
		merge(arr,left,right);
		return;
	}
	
	private void merge(Integer[] arr, Integer[] left, Integer[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}

//	Time complexity - O(n log(n)), O(n^2)
//	Space complexity - O(1)
	@Override
	public String quickSort() throws Exception {
		quickSortHelper(array, 0, array.length - 1);
		return "array sorted..!!\n" + getArray();
	}
	
	private void quickSortHelper(Integer[] unsortedArray, int start, int end) {
		if (start < end) {
			int pivoteIndex = quickSortPartition(unsortedArray, start, end);
			quickSortHelper(unsortedArray, start, pivoteIndex - 1);
			quickSortHelper(unsortedArray, pivoteIndex + 1, end);
		}
	}

	private Integer quickSortPartition(Integer[] unsortedArray, int start, int end) {
		Integer pivoteIndex = start - 1;
		for (int i = start; i < end; i++) {
			if (unsortedArray[i] < unsortedArray[end]) {
				pivoteIndex++;
				int temp = unsortedArray[i];
				unsortedArray[i] = unsortedArray[pivoteIndex];
				unsortedArray[pivoteIndex] = temp;
			}
		}
		int temp = unsortedArray[end];
		unsortedArray[end] = unsortedArray[pivoteIndex + 1];
		unsortedArray[pivoteIndex + 1] = temp;
		return pivoteIndex + 1;
	}
}
