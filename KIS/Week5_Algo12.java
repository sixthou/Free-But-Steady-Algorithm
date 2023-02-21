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

public class Week5_Algo12 {
    public static void main(String... args) throws IOException {
    	
    
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	String[] str =  br.readLine().split(" ");
    	
    	int su = Integer.parseInt(str[0]);
    	int n = Integer.parseInt(str[1]);
    	
    	System.out.println(
    	
    
    	Stream.iterate(new int[] {1}, t -> genList(t[0]+1))
    	  		.flatMapToInt(a -> Arrays.stream(a)) 
    	  		.skip(su-1) 
    	  		.limit(n-su+1)  
    	  		.sum()
    	  		
    			
    			
    	
    			
    	);
    	
    	
    	
    	
    	
    }

    
    private static int[] genList(int num )
    {
    	
    	return IntStream.rangeClosed(1, num).map(t->num).toArray();
    }
    
  
}