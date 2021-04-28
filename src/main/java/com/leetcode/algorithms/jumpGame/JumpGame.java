package com.leetcode.algorithms.jumpGame;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class JumpGame {

    public static int maxResult(int[] nums, int k) {

        Deque<Integer>deque=new LinkedList<>();
        int arrayLength=nums.length;
        int[]dp=new int[arrayLength];

        dp[arrayLength-1]=nums[arrayLength-1];

        deque.offerLast(arrayLength-1);

        for (int i = arrayLength-2 ; i >=0 ; i--) {

            if(deque.peekFirst()-i>k) deque.pollFirst();

            dp[i]=nums[i]+dp[deque.peekFirst()];

            while(!deque.isEmpty()&&dp[deque.peekLast()]<=dp[i]) deque.pollLast();

            deque.offerLast(i);

            }
        return dp[0];
    }
}

