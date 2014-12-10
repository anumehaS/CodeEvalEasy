import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class RightmostChar {

	public static void main(String []args){
		
		BufferedReader br;
		try{
			File f = new File(args[0]);
			br = new BufferedReader(new FileReader(f));
			String next = br.readLine();
			while(next != null)
			{
				if(!next.trim().equals(""))
					printRightmost(next);
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

	private static void printRightmost(String next) {
		if(next.trim().length() == 0)
			return;
		String arr[] = next.split(",");
		char myChar = arr[1].charAt(0);
		int pos = -1;
		
		for(int i =0;i<arr[0].length();i++)
		{
			if(arr[0].charAt(i) == myChar)
				pos = i;
		}
		
		
		System.out.print(pos);
		System.out.println();
	}
}
