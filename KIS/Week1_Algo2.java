package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algo2 {
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	
	    long answer =  solution();
	        
	    System.out.println(answer);
	}
	
	
	private static long solution() 
	{
		//이것이 코딩테스트다 ex2 
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		
		long answer =0L;
	  
	    String[] nmk ={""};
	    String[] arr ={""};
		try {
			  nmk = bf.readLine().split(" ");
			  arr = bf.readLine().split(" ");
			
			  
			  
			  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		List<String> al= Arrays.asList(arr);

		
		al.sort(Comparator.reverseOrder());
		int n = Integer.parseInt(nmk[0]);

		long m = Long.parseLong(nmk[1]);

		long k = Long.parseLong(nmk[2]);
		
		for(int i=1; i<=m;i++)
		{
			if(i!=1 &&i%k==1)
			{
			answer += Long.parseLong(arr[1]);
			
			}
			else
			{
				answer += Long.parseLong(arr[0]);
			}

		}
		
		/*
		Integer[] arr = new Integer[s.length];
		
		Arrays.sort(s);
		


		for( int su : cache)
	    {

		   answer += s/su;
		   s = s- s/su *su;

	   }
		        
		   */
	   return answer;
		  
	}



}
