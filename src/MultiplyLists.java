import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MultiplyLists {

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
					printMultipliedList(next.trim());
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

private static void printMultipliedList(String next) {
	
	String lists [] = next.split("\\|");
	String listOne[] = lists[0].trim().split(" ");
	String listTwo[] = lists[1].trim().split(" ");
	
	
	for(int i = 0;i<listOne.length;i++){
		int num1 = Integer.parseInt(listOne[i].trim());
		int num2 = Integer.parseInt(listTwo[i].trim());
		System.out.print(num1*num2+" ");
	}
	
}
}
