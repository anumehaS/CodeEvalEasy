import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class HappyNumbers {

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
					int number = Integer.parseInt(next);
					HashSet<Integer> allSquares = new HashSet<Integer>();
					System.out.println(isHappyNumber(number,allSquares)?1:0);
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

	private static boolean isHappyNumber(int num, HashSet<Integer> allSquares) {
		
		if(num == 1)
			return true;
		
		if(allSquares.contains(num))
			return false;
		
		allSquares.add(num);
		return isHappyNumber(sumOfSquaredDigits(num),allSquares);
	}

	private static int sumOfSquaredDigits(int num) {
		
		int sum = 0;
		
		while(num >= 1)
		{
			int nextDig = num % 10;
			sum += (nextDig*nextDig);
			num = num/10;
		}
		
		return sum;
	}
}
