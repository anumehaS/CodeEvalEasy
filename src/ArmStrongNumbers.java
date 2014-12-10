import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ArmStrongNumbers {

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
					System.out.print(isArmStrong(next.trim()));
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

private static boolean isArmStrong(String next) {
	
	int num = Integer.parseInt(next);
	int pow = next.length();
	int myNum = 0;
	for(int i = 0; i< pow; i++) {
		
		int digit = Character.getNumericValue(next.charAt(i));
		myNum += Math.pow(digit,pow);
		
	}
	
	return num == myNum;
}
}
