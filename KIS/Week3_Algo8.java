package algo_project;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.StringWriter;


public class Week3_Algo8 {

	

	
	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		String s1 = "Zbcdefg";
		String s2 = "sadafd";


	 int answer =  Solution.solution(s1,s2);
	  
	    System.out.println(answer);

	}


class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;
        
        
        int[][] arr1 = strToArray(str1.toUpperCase());
        int[][] arr2 = strToArray(str2.toUpperCase());
        
        int kyo = calKyo(arr1,arr2);
        
       // System.out.println("kyo= "+kyo);
        
        int hab = calHab(arr1,arr2);
        
       // System.out.println("hab= "+hab);
        
       // System.out.println("jacad = "+ jacad(kyo,hab));
        
     
        answer = jacad(kyo,hab);
        
        
        
        return answer;
    }
    
    
      public String inputToStr (String st)
    {
    	
    	
    	return st.chars().filter(Character::isAlphabetic).collect(StringWriter::new , 
    			StringWriter::write, (swl, swr)-> swl.write(swr.toString())).toString();
    	
    	
    }
    
    public static int[][] strToArray(String st)
    {
    	int[][] arr = new int[27][27];
    	
    	
        for(int i=0; i<=st.length()-2;i++)
    	{
    	
        	if(st.substring(i, i+2).chars().filter(Character::isAlphabetic).collect(StringWriter::new , 
        			StringWriter::write, (swl, swr)-> swl.write(swr.toString())).toString().length()<2		
        	 )
        	{

        		continue;
        	}
        	
        	arr[Alphabat.valueOf(st.substring(i, i+1)).ordinal()][Alphabat.valueOf(st.substring(i+1, i+2)).ordinal()] +=1;
    	
    	}
    	
        
    	
    	
    	
    	return arr;
    }
    
    public static int calKyo(int[][] arr1, int[][] arr2)
    {
    	int answer =0;
    			
    
    	for(int i=0; i<27;i++)
    	{
    		for(int j=0;j<27;j++)
    		{
    			answer += Math.min(arr1[i][j],arr2[i][j]);
    			
    			
    			
    		}
    		
    		
    	}
    	
    	
    	
    	
    	return answer; 
    }
    public static int calHab(int[][] arr1, int[][] arr2)
    {
    	int answer =0;
    			
    
    	for(int i=0; i<27;i++)
    	{
    		for(int j=0;j<27;j++)
    		{
    			answer += Math.max(arr1[i][j],arr2[i][j]);
    			
    			
    			
    		}
    		
    		
    	}
    	
    	
    	
    	
    	return answer; 
    }
    
    public static int jacad(double num1, double num2)
    {
    	if(num1==0&&num2==0)
    	{
    		
    		return (int)1.0*65536;
    	}
    	else
    	{
    		
    		return (int)((num1/num2)*65536);
    	}
    	
    	
    }
    
}

enum Alphabat { A, B, C, D, E,
	            F,G,H,I,J,
	            K,L,N,M,O,
	            P,Q,R,S,T,
	            U,V,W,X,Y,
	            Z }

}

