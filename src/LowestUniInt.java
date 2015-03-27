import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LowestUniInt {


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
					printLowestInt(next.trim());
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

private static void printLowestInt(String next) {
	
	String [] allNums = next.trim().split(" ");
	int numsPresent [] = {0,0,0,0,0,0,0,0,0,0};
	int min = 0;
	for(int j=0;j<allNums.length;j++)
	{
		int curNum = Integer.parseInt(allNums[j]);
		if(numsPresent[curNum] == 0)
			numsPresent[curNum] = j+1;
		else
			numsPresent[curNum] =-1;
	}
	
	for(int i=0; i< 9; i++)
	{
		if(numsPresent[i] > 0){
			min = numsPresent[i];
			break;
		}
	}
	
	System.out.print(min);
}


}
