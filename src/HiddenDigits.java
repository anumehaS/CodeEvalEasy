import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HiddenDigits {


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
					printHiddenDigits(next.trim());
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

private static void printHiddenDigits(String next) {
	
	//iterate through string
	//if a number - ascii 48 to 57 - print it
	//if a lowercase char between ascii 97 and 106 - print it - 97
	boolean noneFound = true;
	for(char c: next.toCharArray()) {
		
		if((int)c >=48 && (int)c <= 57 ){
			System.out.print(c);
			noneFound = false;
		}else if((int)c >=97 && (int)c <= 106) {
			System.out.print((int)c-97);
			noneFound = false;
		}
		
	}
	if(noneFound)
		System.out.print("NONE");
	
}

	
	
}
