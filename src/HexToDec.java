import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HexToDec {


	public static void main(String []args){
			
			BufferedReader br;
			try{
				File f = new File(args[0]);
				br = new BufferedReader(new FileReader(f));
				String next = br.readLine();
				while(next != null)
				{
					System.out.println(convertToDec(next));
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

	private static int convertToDec(String next) {
		
		int intVal=0;
		int index = next.length() - 1;
		
		for(char c:next.toCharArray()) {
			int num;
			if(c >= 97 && c<=106)
			{ 
				num = c - 87;
			} else 
				num = Character.getNumericValue(c);
			double indexVal = Math.pow(16,index);
			intVal += num*indexVal;
			index--;
		}
		return intVal;
	}

	
}
