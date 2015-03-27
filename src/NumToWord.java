import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class NumToWord {

	static HashMap<String, Integer> mapping = new HashMap<String,Integer>();
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
					printWords(next.trim());
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

private static void populateMapping() {
	mapping.put("one",1);
	mapping.put("two",2);
	mapping.put("three",3);
	mapping.put("four",4);
	mapping.put("five",5);
	mapping.put("six",6);
	mapping.put("seven",7);
	mapping.put("eight",8);
	mapping.put("nine",9);
	mapping.put("zero",0);
		
}

private static void printWords(String next) {
	
	String numbers[] = next.split(";");
	for(String num:numbers)
	{
		System.out.print(mapping.get(num));
	}
	
}



}
