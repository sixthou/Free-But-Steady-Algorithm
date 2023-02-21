import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Week5_Algo11

 {
    public static void main(String... args) throws IOException {
    	
    	
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int k=0;k<n;k++)
    	{
        List<Integer> str =  Collections.list(new StringTokenizer(br.readLine(), " ")).stream().map(token -> Integer.parseInt( String.valueOf(token))).collect(Collectors.toList());

     	
   
    	
    	List<Integer> strList = str.stream().sorted().collect(Collectors.toList());
      	System.out.println(strList.get(7) );
    	}

    	
    	
    
    }

 
    
}