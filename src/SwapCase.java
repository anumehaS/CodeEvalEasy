import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SwapCase {


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
					printSwapped(next.trim());
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

private static void printSwapped(String next) {
	
	
	for(int i = 0; i<next.length(); i++)
	{
		char nextChar = next.charAt(i);
			swap(nextChar);
	}
	
}

private static void swap(char nextChar) {
	//if lowercase then capitalize else return as is
	if(nextChar>=97 && nextChar<=122){
		System.out.print(Character.toUpperCase(nextChar));
			return;
	}
	if(nextChar>=65 && nextChar<=90){
		System.out.print(Character.toLowerCase(nextChar));
		return;
	}
	
	System.out.print(nextChar);
}


}
