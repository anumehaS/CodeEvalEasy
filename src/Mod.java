import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Mod {

	
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
					String arr[] = next.split(",");
					int n = Integer.parseInt(arr[0]);
					int m = Integer.parseInt(arr[1]);
					
					System.out.println(calcMod(n,m));
				}
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

private static int calcMod(int n, int m) {
	
	int div = n/m;
	return n - (m*div);
}

}
