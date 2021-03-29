package com.leetcode.algorithms.firstMissingPositive;

import java.util.Arrays;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        final int firstExpected = 1;
        int resultExpected=1;
        int[]resultArray;

        resultArray= Arrays.stream(nums).boxed().sorted().filter(element -> element >= firstExpected).
                            mapToInt(i->i).toArray();

        if(resultArray.length==1&&resultArray[0]==1){
            ++resultExpected;
        }

        for(int i = 1; i < resultArray.length; i++) {

            if(resultArray[0]==1){

                if((resultArray[i]-resultArray[i-1])>1){
                    resultExpected=++resultArray[i-1];
                    break;
                }
                if(i==resultArray.length-1){
                    resultExpected=++resultArray[resultArray.length-1];
                }
            }
        }
        return resultExpected;
    }
}
