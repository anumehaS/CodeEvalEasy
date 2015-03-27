import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MixedContent {

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
					printSeparatedContent(next.trim());
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

private static void printSeparatedContent(String next) {
	String allItems[] = next.split(",");
	
	String nums[] = separateContent(allItems);
	
	printNums(nums);
		
}

private static String[] separateContent(String[] allItems) {
	
	boolean first = true;
	ArrayList<String> allNums = new ArrayList<String>();
	for(int i = 0; i< allItems.length;i++)
	{
		try {
			int num = Integer.parseInt(allItems[i].trim());
			allNums.add(allItems[i]);
		}catch (NumberFormatException e) {
			if(first)
			{
			 System.out.print(allItems[i]);
			 first = false;
			}
			else
				System.out.print(","+allItems[i]);
			
		}
	}
	if(!first && allNums.size() >=1)
	System.out.print("|");
	return allNums.toArray(new String[allNums.size()]);
}

private static void printNums(String[] nums) {
	
	if(nums.length >=1)
	System.out.print(nums[0]);
	for(int i =1;i<nums.length;i++)
	{
		System.out.print(","+nums[i]);
	}
	
	
}


}
