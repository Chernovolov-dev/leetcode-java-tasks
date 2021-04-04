package com.leetcode.algorithms.shortestSubarray;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarray {

    public static int getLengthOfShortestSubarray(int[] A, int K) {

        int arrayLength=A.length;

        int[]prefixSum=new int[arrayLength+1];

        for (int i = 0; i < arrayLength ; i++) {
            prefixSum[i+1]=prefixSum[i]+A[i];
        }

        int result=Integer.MAX_VALUE;
        Deque<Integer>deque=new LinkedList<>();

        for(int k=0;k<arrayLength;k++){

            deque.offerLast(k);

            while(!deque.isEmpty()&&prefixSum[k+1]-prefixSum[deque.peekLast()]<=0){
                deque.removeLast();
            }
            while (!deque.isEmpty()&&prefixSum[k+1]-prefixSum[deque.peekFirst()]>=K){
                result=Math.min(result,k-deque.removeFirst()+1);
            }
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}
