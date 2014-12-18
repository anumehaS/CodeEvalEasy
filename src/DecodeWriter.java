import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DecodeWriter {

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
					printNameOfWriter(next.trim());
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

private static void printNameOfWriter(String next) {
	String params [] = next.split("\\|");
	char author[] = params[0].trim().toCharArray();
	String keys[] = params[1].split(" ");
	
	for(int i =1;i<keys.length;i++)
	{
		int position = Integer.parseInt(keys[i])-1;
		System.out.print(author[position]);
	}
	
}

}
