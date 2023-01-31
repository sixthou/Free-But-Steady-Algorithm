package algo_project;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;



public class Week2_Algo4 {

	
	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		String s = "asd"; 

	    Solution.solution(s);
	    System.out.println(answer);

	}


	static int answer =0;


class Solution {
    static boolean solution(String s) {
    	boolean answer =true;
	
	int cnt =0;
	/*
	for( String temp : Arrays.asList(s.split("")))
	{
		//System.out.println("temp "+temp);
		
		if(temp.equals("("))
		{
			cnt++;
		}
		else
		{
			cnt--;
		}
		
		
		if(cnt<0)
		{
			answer = false;
			break;
		}
	}
    
    */
        
    for( int i=0; i<s.length();i++)
	{
		//System.out.println("temp "+temp);
		
		if(s.charAt(i)=='(')
		{
			cnt++;
		}
		else
		{
			cnt--;
		}
		
		
		if(cnt<0)
		{
			answer = false;
			break;
		}
	}
        
    
	if(cnt!=0)
	{
		answer = false;
	}
	
	
	
    return answer;
    
    }
}



}