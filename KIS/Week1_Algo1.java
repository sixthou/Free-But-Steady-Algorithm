package com.example.demo.service;
 
public class Algo1 {
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int s = 5450; 
		
	    int answer =  solution(s);
	        
	    System.out.println(answer);
	}
	
	
	private static int solution(int s) 
	{
		//이것이 코딩테스트다 ex1 
			
		int answer =0;
			
		int[] cache = {500,100,50,10};
			
		for( int su : cache)
	    {

		   answer += s/su;
		   s = s- s/su *su;

	   }
		        
		   
	   return answer;
		  
	}



}
