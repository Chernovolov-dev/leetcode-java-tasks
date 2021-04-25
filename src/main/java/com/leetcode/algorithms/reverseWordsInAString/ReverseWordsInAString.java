package com.leetcode.algorithms.reverseWordsInAString;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        StringBuilder stringBuilder=new StringBuilder();

        for (int i = 0; i < s.length() ; i++) {

            if(s.charAt(i)==' ') continue;

            int startIndex=i;

            while(i<s.length()&&s.charAt(i)!=' ') i++;

            if(stringBuilder.length()==0)
                stringBuilder.insert(0,s.substring(startIndex,i));

            else
                stringBuilder.insert(0, " ").insert(0,s.substring(startIndex,i));
        }
        return stringBuilder.toString();
    }
}
