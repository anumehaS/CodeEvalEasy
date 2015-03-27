import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class RomanNumerals {

	static HashMap<Integer, String> mapping = new HashMap<Integer,String>();
	public static void main(String []args){
			
		populateMapping();
			BufferedReader br;
			try{
				File f = new File(args[0]);
				br = new BufferedReader(new FileReader(f));
				String next = br.readLine();
				while(next != null)
				{
					if(!next.trim().equals(""))
					{	
						printRomanNum(next.trim());
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

	private static void printRomanNum(String next) {
		
		int num = Integer.parseInt(next);
		int placeValue = 1;
		int digit;
		StringBuilder romanNum = new StringBuilder();
		while(num != 0)
		{	
			digit = num % 10;
			romanNum.insert(0, (convertToRoman(digit,placeValue)));
			num = num / 10;
			placeValue = placeValue*10;
		}
		
		System.out.print(romanNum.toString());
	}
	private static String convertToRoman(int digit, int placeValue) {
		
		StringBuilder sb = new StringBuilder("");
		if(digit == 0)
			return sb.toString();
		if(digit == 1 || digit == 5)
		{
			sb.append(mapping.get(digit*placeValue));
			return sb.toString();
		}
		
		if(digit < 4)
		{
			for(int i = 0; i< digit; i++){
				sb.append(mapping.get(placeValue));
			}
			return sb.toString();
		}
		
		if(digit == 4 || digit == 9)
		{
			sb.append(mapping.get(placeValue));
			sb.append(mapping.get(placeValue * (digit + 1)));
			
			return sb.toString();
		}
		
		sb.append(mapping.get(5*placeValue));	
		sb.append(convertToRoman(digit-5,placeValue));
		
		
		return sb.toString();
	}
	private static void populateMapping() {
		mapping.put(1,"I");
		mapping.put(5,"V");
		mapping.put(10,"X");
		mapping.put(50,"L");
		mapping.put(100,"C");
		mapping.put(500,"D");
		mapping.put(1000,"M");
		
	}

}
