import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ShortestRepetition {
	public static void main(String []args){
		
			BufferedReader br;
			try{
				File f = new File(args[0]);
				br = new BufferedReader(new FileReader(f));
				String next = br.readLine();
				while(next != null)
				{
					if(!next.trim().equals(""))
					{	
						findShortestRep(next.trim());
					} 
					
					System.out.println();
					next=br.readLine();
				}
				br.close();
			}catch(FileNotFoundException e)
			{
				System.out.println("File Not Found!");
				
			}catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}

	private static void findShortestRep(String next) {
		
		int rightMostZero = 0;
		int matchCount = 0;
		int endOfPeriod = 0;
		char curEndOfPeriod = next.charAt(0);
		
		for(int i =1; i<next.length();i++) {
			
			if(next.charAt(i) == curEndOfPeriod)
				{ 	
					endOfPeriod ++;
					curEndOfPeriod = next.charAt(endOfPeriod);
					matchCount ++;
				}
			else
			{
				rightMostZero = i;
				matchCount = 0;
				endOfPeriod = 0;
				curEndOfPeriod = next.charAt(0);
			}
		}
		
		if(rightMostZero == next.length() - 1 || matchCount % (rightMostZero +1) != 0)
		{	System.out.print(next.length());
			return;
		}
		
		System.out.print(rightMostZero+1);
		
			
		
	}

}
