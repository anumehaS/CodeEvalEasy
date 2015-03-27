import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TheMajorElement {

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
					System.out.print(findMajorElement(next.trim()));
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

private static String findMajorElement(String next) {
	
	int maxCount = 0;
	String maxCountEle="";
	int [] allCounts = new int[101];
	
	String allNums [] = next.split(",");
	
	for(String num: allNums){
		
		int curNum = Integer.parseInt(num);
		allCounts[curNum] ++;
		if(allCounts[curNum] > maxCount) {
			maxCount = allCounts[curNum];
			maxCountEle = num;
		}
	}
	
	if(maxCount > (allNums.length/2))
		return maxCountEle;
	else
		return "None";
}


}
