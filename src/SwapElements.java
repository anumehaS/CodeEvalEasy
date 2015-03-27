import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SwapElements {

	static String []numbers;
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
					printSwappedList(next.trim());
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

	private static void printSwappedList(String next) {
		 
		String [] temp = next.split(":");
		
		numbers = temp[0].trim().split(" ");
		String [] swaps = temp[1].trim().split(", ");
		
		executeSwaps(swaps);
		
		printResult();
		
	}

	private static void printResult() {
		for(String s: numbers) {
			System.out.print(s+" ");
		}
		
	}

	private static void executeSwaps(String[] swaps) {
		for(String swap:swaps) {	
			swapPos(swap);
		}
	}

	private static void swapPos(String swap) {
		
		String [] positions = swap.split("-");
		
		int left = Integer.parseInt(positions[0].trim());
		int right = Integer.parseInt(positions[1].trim());
		
		String temp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temp;
		
	}
}
