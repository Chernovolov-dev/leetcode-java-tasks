package com.leetcode.algorithms.medianOfSortedArrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MedianOfTwoSordedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

         double mediumResult=0;

        //first array
        Integer[]firstArray= Arrays.stream(nums1).boxed().toArray(Integer[]::new);

        //second array
        Integer[]secondArray=Arrays.stream(nums2).boxed().toArray(Integer[]::new);

        //merged array
        int[]mergedArray=Stream.of(firstArray,secondArray).flatMap(Stream::of).mapToInt(i->i).sorted().toArray();

        boolean isEven=(mergedArray.length % 2 == 0);

        if(isEven){
            mediumResult=(((mergedArray[mergedArray.length/2])+(mergedArray[(mergedArray.length/2)-1]))/2.0);
        }
        if(mergedArray.length==1){
            mediumResult=(double) mergedArray[mergedArray.length-1];
        }
        if(!isEven){
            mediumResult=(double) mergedArray[(mergedArray.length/2)];
        }

        return mediumResult;
    }
}
