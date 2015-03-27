import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//convert seq to array..iterate through it and count..when number changes..print count and prev num
public class CompressedSequence {

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
					compressSequence(next.trim());
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

private static void compressSequence(String next) {
	
	String [] allNums = next.split(" ");
	
	int curNumCount =1;
	String curNum = allNums[0];
	
	for(int i =1; i< allNums.length;i++) {
		
		if(curNum.equals(allNums[i]))
			curNumCount++;
		else
		{
			System.out.print(curNumCount+" "+curNum+" ");
			curNum = allNums[i];
			curNumCount = 1;
		}
	}
	
	System.out.print(curNumCount+" "+curNum);
	
}
}
