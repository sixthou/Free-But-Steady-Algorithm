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

public class Main {
	
	
	
	
    public static void main(String args[]) {
    	
    	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String str ="";
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        StringTokenizer st = new StringTokenizer(str);
        
        
    	int n1 = Integer.parseInt(st.nextToken());
    	int n2 = Integer.parseInt(st.nextToken());
    	
    	System.out.println(n1+n2);
        
    
    }    
    
   
 
    
}
