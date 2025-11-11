package com.dsa.service.impl;

import org.springframework.stereotype.Service;

import com.dsa.service.DataStructureServiceV;

@Service
public class DataStructureServiceImplV implements DataStructureServiceV {

	@Override
	public String ping() throws Exception {
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
}
