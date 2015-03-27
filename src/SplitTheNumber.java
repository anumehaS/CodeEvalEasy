import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SplitTheNumber {

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
					printAnswer(next.trim());
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

private static void printAnswer(String next) {
	
	if(next.contains("+")) 
		System.out.print(calculate(next,"+"));
	else
		System.out.print(calculate(next,"-"));	
}

private static int calculate(String next, String operation) {

	String temp[] = next.split(" ");
	
	int leftLen = temp[1].indexOf(operation);
	
	int leftNum = Integer.parseInt(temp[0].substring(0, leftLen));
	int rightNum = Integer.parseInt(temp[0].substring(leftLen));
	
	switch(operation) {
	
	case "-" : 
		return leftNum - rightNum;
	case "+" :
		return leftNum + rightNum;
		
	}
	
	return -1;
}


}
