package com.leetcode.algorithms.splitIntoSubarrays;

public class SplitSubarray {

    private static int countWays;

    public static int waysToSplit(int[] nums) {

        int left,mid,right;
        countWays=0;
        int arrayLength=nums.length;

        //Create array storing the sum of subarrays
        int[]prefixSum=new int[arrayLength+1];

        //Fill array with the sums of subarrays
        for (int i = 0; i < arrayLength ; i++) {
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        for (int i = arrayLength; i >2 ; i--) {

            right=prefixSum[arrayLength]-prefixSum[i-1];

            binarySearch(prefixSum, i,right);

        }
        System.out.println(countWays);
        return countWays;
    }

    private static void binarySearch(int[]array,int index,int rightPartSum){

        int left=2;
        int right=index-1;

        while(left<=right){

            int mid=(left+right)/2;

            if(array[mid-1]<=array[right]-array[mid-1]&&array[right]-array[mid-1]<=rightPartSum){

                countWays++;
                break;
            }
            else{
                left=mid+1;
            }
        }
    }
}
