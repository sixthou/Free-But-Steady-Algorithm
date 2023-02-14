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
    public int solution(int n, int t) {
        int answer = n;
        
        
        for(int i=0;i<t;i++)
        {
            answer *= 2;
            
            
        }
        
        
        return answer;
    }
}

}

