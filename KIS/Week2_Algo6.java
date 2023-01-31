package algo_project;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



public class Week2_Algo6 {

	

	
	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		String s = "Zbcdefg";

	  int[] answer =  Solution.solution(s);
	  
	    System.out.println(answer);

	}


	
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	       int[] answer = new int[commands.length];
		
		int cnt =0;
		
		
		ArrayList<KClass> arr = new ArrayList<KClass>();

		for(int i=0; i< array.length;i++)
		{
			arr.add(new KClass(array[i],i+1));
			
		}
		
		
		Collections.sort(arr);
		
		
			
		for(int i = 0; i<commands.length;i++)
		{
			


			//Stream<KClass> stream = arr.stream();
			
			//stream.filter(a ->a.index>=commands[i][0] && a.index<=commands[i][1]).skip(commands[i][2]-1).limit(1).forEach(a -> System.out.println("값 : "+a.getNum()));
			
			int temp = commands[i][2];
			
			Iterator iter = arr.iterator();
			

		
		
		
		
			
			while(iter.hasNext())
			{
				KClass aa = (KClass)iter.next();
			
				if(aa.getIndex()>=commands[i][0] && aa.getIndex()<=commands[i][1])
				{
					temp--;
					
					if(temp==0)
					{
						//System.out.println("num = "+aa.getNum() + " index = "+aa.getIndex() );
						
						answer[i]=aa.getNum();
					}
					
				}
					//System.out.println("num = "+aa.getNum() + " index = "+aa.getIndex() );
				
				
			}
		
			//System.out.println("------");
	    }
	        
	        
	    return answer;
	    }

		public static int[] solution(String s) {
			// TODO Auto-generated method stub
			return null;
		}
	}


	class KClass implements Comparable<KClass>{
		
		int num;
		int index;
		
		KClass (int i, int b)
		{
			this.num=i;
			this.index=b;
			
			
		}
		
		
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}


		@Override
		public int compareTo(KClass o) {
			// TODO Auto-generated method stub
			
			int dab = 0;
			
			
			if (this.num - o.num>0)
				dab = 1; 
			else if ( this.num - o.num==0) 
				dab = 0;
			else
				dab = -1;
		//	System.out.println("this.num = " +this.num + " o.num = "+o.num+" dab = "+dab);
			
			return dab;
		}
		
	}


}

