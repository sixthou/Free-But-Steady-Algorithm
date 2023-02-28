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
    public static void main(String... args) {
    	
    	
        int num =-1;
	    int dab = 1;
        
        
	  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	try {
			num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	    if (num>-1)
        {
		    dab = fac(num);
        }
            
	    System.out.println(dab);
    }

    
    private static int fac(int num )
    {
    	if (num == 1)
	    	return 1;
        
    	return num * fac(num - 1);
    }
    
    
}