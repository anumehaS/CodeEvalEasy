import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class SetIntersection {

	public static void main(String []args){
		
		BufferedReader br;
		try{
			File f = new File(args[0]);
			br = new BufferedReader(new FileReader(f));
			String next = br.readLine();
			while(next != null)
			{
				printIntersection(next);
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

	private static void printIntersection(String next) {
		
		String arr[] = next.split(";");
		String list1[] = arr[0].split(",");
		String list2[] = arr[1].split(",");
		
		HashSet<String> set1 = new HashSet<String>();
		for(String s:list1){
			set1.add(s);
		}
		
		boolean first = true;
		for(String s:list2){
			if(set1.contains(s))
			{	
				if(first)
				{
					System.out.print(s);
					first = false;
				}
				else
					System.out.print(","+s);
			}
		}
		
		
		
	}
}
