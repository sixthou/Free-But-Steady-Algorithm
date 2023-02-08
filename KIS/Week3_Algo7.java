package algo_project;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



public class Week3_Algo7 {

	

	
	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		String s = "01097531233";

	 String answer =  Solution.solution(s);
	  
	    System.out.println(answer);

	}

class Solution {
		
		public static String solution(String s) {
    	String answer = "";
        for(int i=0; i<s.length() ; i++){
            if(i>=s.length()-4)
                answer = answer+String.valueOf(s.charAt(i));
            else
                answer = answer+"*";    
        }
        return answer;
        		
		}
}

}

