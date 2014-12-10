import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UniList {

	public static void main(String args[]) {
		
		BufferedReader br;
		try{
			File f = new File(args[0]);
			br = new BufferedReader(new FileReader(f));
			String next = br.readLine();
			while(next != null)
			{
				printUniValues(next);				
				next=br.readLine();
				System.out.println();
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

	private static void printUniValues(String next) {
		
		String []allNums = next.split(",");
		int count = 0;
		String prev = ""; 
		while(count!=allNums.length) {
			
			if(!prev.equals(allNums[count])) {
				if(count == 0)
					System.out.print(allNums[count]);
				else
					System.out.print(","+allNums[count]);
			}
			
			prev = allNums[count];
			count++;
				
		}
		
		
	}


}
