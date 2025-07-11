package com.tuf.dsa;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {1,0,2,3,2,0,0,4,5,1};
       // bruteSolution(nums);

        optimalsolution(nums);
        ArrayUtil.print(nums);
    }

    private static void optimalsolution(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 ){
                j=i;
                break;
            }
        }
        if(j==-1){
            System.out.println("Array does not contains zero numbers..");
            return;
        }
        System.out.println("Find and swap zero with non-zero");
        for (int i = j+1;i<nums.length; i++){
            if(nums[i] !=0){
                swapNumbers(nums,j,i);
                j++;
            }
        }
    }

    private static void swapNumbers(int[] nums, int j, int i) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    }

    private static void bruteSolution(int[] nums) {
        int[] temp = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                temp[index++] = nums[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        for (int i = temp.length; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
