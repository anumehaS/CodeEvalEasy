import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Capitalize {


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
					printCapitalized(next.trim());
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

private static void printCapitalized(String next) {
	
	
	boolean newWord = true;
	for(int i = 0; i<next.length(); i++)
	{
		char nextChar = next.charAt(i);
		if(newWord && nextChar!=' ')
		{
			printCapital(nextChar);
			newWord = false;		
		} else 
		{
			System.out.print(nextChar);
			if(nextChar == ' ')
				newWord = true;
		}
	}
	
}

private static void printCapital(char nextChar) {
	//if lowercase then capitalize else return as is
	System.out.print((nextChar>=97 && nextChar<=122)?Character.toUpperCase(nextChar):nextChar);
}


}
