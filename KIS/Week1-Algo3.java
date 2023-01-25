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

public class Algo3 {
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	
	    long answer =  solution();
	        
	    System.out.println(answer);
	}
	
	
	private static long solution() 
	{
		//이것이 코딩테스트다 ex3 
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		
		long answer =0L;
	  
	    String[] nm ={""};
	    
	    String str ="";

	    String[] arr = {""};
	    
	    int n=0;
	    int m =0;
	    
	    
	    
		try {
			  nm = bf.readLine().split(" ");
			  n= Integer.parseInt(nm[0]);
			  m= Integer.parseInt(nm[1]);
			  
			  for(int i=0; i< n;i++)
			  {
				  str+=bf.readLine()+" ";
			  }
			  
			  arr = str.split(" "); //split 지정자는 패
			   
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		int min=99999;
		
		int max = -99999;
		
		for(int i=0; i<arr.length;i++)
		{
			if((i+1)!=1 && (i+1)%m==0 )
			{

				if (Integer.parseInt(arr[i])<=min)
				{
					min = Integer.parseInt(arr[i]);
					
				}
				

				if (min>=max)
				{
					max = min;
				}
				
				min = 99999;
			}
			else
			{
				if (Integer.parseInt(arr[i])<=min)
				{
					min = Integer.parseInt(arr[i]);
				}
			}

		}
		
	
	   return max;
		  
	}



}
