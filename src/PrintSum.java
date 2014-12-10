import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PrintSum {

	public static void main(String []args) {
		int sum = 0;
		BufferedReader br;
		try{
			File f = new File(args[0]);
			br = new BufferedReader(new FileReader(f));
			String next = br.readLine();
			while(next != null)
			{
				int num = Integer.parseInt(next);
				sum += num;
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
		
		
		System.out.println(sum);
	}
}
