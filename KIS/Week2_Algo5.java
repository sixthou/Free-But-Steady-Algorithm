package algo_project;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;



public class Week2_Algo5 {

	
	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		String s = "Zbcdefg";

	  String answer =  Solution.solution(s);
	  
	    System.out.println(answer);

	}


	static int answer =0;

	
	


}

class  Solution {
    public static String solution(String s) {
        String answer ="";
    	String[] ss = s.split("");
    
    			
    	Arrays.sort(ss, new MyDescending());


    	
    	
        return String.join("",ss);
    }
}


class MyDescending<T extends String > implements Comparator {

	public int compare(Object o1, Object o2) { // o1이 뒤에 글자 
		// TODO Auto-generated method stub
		
		int dab =0;
		if(o1 instanceof String && o2 instanceof String)
		{
			String a1 = (String)o1;
			String a2 = (String)o2;
			
			dab =-a1.compareTo(a2);
			
			//System.out.println("a1 ="+a1+" a2="+a2+" : "+a1.compareTo(a2));
			
		}
			
		
		
		return dab;
		
		
		
	}
	
}
