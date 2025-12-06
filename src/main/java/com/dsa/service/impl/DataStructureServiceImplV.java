package com.dsa.service.impl;

import org.springframework.stereotype.Service;

import com.dsa.service.DataStructureServiceV;

@Service
public class DataStructureServiceImplV implements DataStructureServiceV {

	@Override
	public String ping() throws Exception {
		int[] arr = {7,1,2,3,4,5,6};
		//System.out.println(binarySearchInRotatedArray(arr, 7));
		// System.out.println(binarySearch(arr,3));
		// for(int i=0;i<arr.length;i++)
		// {
		// 	System.out.println(arr[i]);
		// }
		return "success";
	}

	@Override
	public int[] selectionSort(int[] arr) throws Exception{
		int min=0;
		for(int i=0;i<arr.length-1;i++)
		{	min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		return arr;
	}

	@Override
	public int[] bubbleSort(int[] arr) throws Exception{
		int min=0;
		for(int i=0;i<arr.length-1;i++)
		{	min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(arr[j]<arr[min])
				{
					min=j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		return arr;
	}

	@Override
	public int[] mergeSort(int[] arr) throws Exception{
		if(arr.length<=1)
		return arr;
		int mid = arr.length/2;
		int[] left = new int[mid];
		int[] right = new int[arr.length-mid];
		for(int i=0;i<mid;i++)
		{
			left[i]=arr[i];
		}
		for(int i=mid;i<arr.length;i++)
		{
			right[i-mid]=arr[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(arr,left,right);

		return arr;
	}

	private void merge(int[] arr,int[] left,int[] right){
		int i=0;
		int j=0;
		int k=0;

		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			arr[k++]=left[i++];
			else
			arr[k++]=right[j++];
		}

		while(i<left.length)
		{
			arr[k++]=left[i++];
		}
		while(i<left.length)
		{
			arr[k++]=right[j++];
		}
	}

	@Override
	public int[] quickSort(int[] arr) throws Exception{
		quickSortRecursion(arr,0,arr.length-1);
		return arr;
	}

	private void quickSortRecursion(int[] arr,int low,int high){
		if (low >= high) return;
			int pivot = arr[high];
			int i = low-1;
			for(int j=low;j<high;j++)
			{
				if(arr[j]<=pivot)
				{
					i++;
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			int temp = arr[i 	+ 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
			int p = i+1;
			quickSortRecursion(arr, low, p - 1);
			quickSortRecursion(arr, p+1,high);
		
	}

	@Override
	public int binarySearch(int[] arr,int searchNum) throws Exception{
		int left=0;
		int right = arr.length-1;
		
		while(left<=right)
		{   int mid = left+(right-left)/2;
			
			if(arr[mid] == searchNum)
			{	
				return mid;
			}
			if(arr[mid] < searchNum)
			{
				left = mid+1;
			}
			else
				right = mid-1;
		}
		return -1;
	}

	public int binarySearchInRotatedArray(int[] arr,int searchNum) throws Exception{
		int left = 0;
		int right = arr.length-1;
		
		while(left<=right)
		{	int mid = left + (right - left) / 2;
			if(arr[mid] == searchNum) return mid;
			if(arr[left]<=arr[mid])
			{
				if(arr[left]<=searchNum && searchNum < arr[mid])
				{
					right = mid-1;
				}
				else{
					left = mid+1;
				}
			}
			else 
			{ 
				if(arr[mid]<searchNum && searchNum <= arr[right])
				{
					left = mid+1;
				}
				else{
					right = mid-1;
				}
			}
		}
		return -1;
	}

}
