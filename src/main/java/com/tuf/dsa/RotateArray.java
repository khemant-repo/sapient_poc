package com.tuf.dsa;
class RotateArray {
	public static int[] rotateRightByKPositions(int[] nums, int k) {

		for (int i = 0; i < k; i++) {
			int temp = nums.length - 1;
			for (int j = 1; j < nums.length - 2; j++) {
				nums[i + 1] = nums[i];
			}
			nums[nums.length - 1] = temp;
		}
		
		
		return nums;
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};
		int k = 3;
		//nums = rotateRightByKPositions(nums, k);

        //leftRotateByKPositions(nums, k);
		//leftRotateByKPositionsWithReverse(nums, k);
		rightRotateByKPositions(nums, k);
      //  print(nums);
	}

	private static void rightRotateByKPositions(int[] arr, int k) {
		//Input: nums = [1,2,3,4,5,6,7], k = 3
		//Output: [5,6,7,1,2,3,4]
		int size = arr.length;
		k = k % size;
		int temp[] = new int[k];

		//create temp
		for (int i=size-k ; i<size ; i++) {
			temp[(i-k)-1] = arr[i];
		}
		//shift
		//Input: nums = [1,2,3,4,5,6,7]
		// i
		int count = 1;
		for (int i = k; i >= 0; i--) {
			arr[size-count] = arr[i];
			count ++;
		}
		//push back temp

		for (int i = 0; i < k; i++) {
			arr[i] = temp[i];
		}
		print(arr);
		//print(temp);

	}

	private static void leftRotateByKPositionsWithReverse(int[] arr, int k) {
		reverse(arr,0,k-1);
		System.out.println("pass1: ");
		print(arr);
		reverse(arr,k,arr.length-1);
		System.out.println("pass2: ");
		print(arr);
		reverse(arr,0,arr.length-1);
		System.out.println("pass3: ");

		print(arr);
	}

	private static void reverse(int[] arr, int startIndex, int endIndex) {
		while(startIndex<=endIndex){
			int temp = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}

	private static void print(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] +" ");
		}
	}

	private static void leftRotateByKPositions(int[] arr, int k) {
		// TODO Auto-generated method stub
		// Input: nums = [1,2,3,4,5,6,7], k = 3
		// Output: [2,3,4,5,6,7,1]
		int size = arr.length;
		 k = k % size;
		// create temp	
		int[] temp = new int[k];
		for(int i = 0; i < k; i++) {
			temp[i] = arr[i];
		}
		// shift array
		for (int i = k; i<size; i++){
			arr[i-k] = arr[i];
		}
		// put back temp
		for (int i = size-k;i<size;i++){
			arr[i]=temp[i-(size-k)];
		}

		//print
		print(arr);

	}
}