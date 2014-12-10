import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SelfDescribing {
	
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
					System.out.println(isSelfDescribing(number)?1:0);
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

private static boolean isSelfDescribing(int num) {
	
	int numArr[] = constructNum(num);
	
	for(int i = numArr[10] -1; i>=0;i--)
	{
		int nextDig = num % 10;
		if(nextDig != numArr[i] )
			return false;
		num=num/10;
	}
	
	
	return true;
}

private static int[] constructNum(int num) {
	int numArr[] = {0,0,0,0,0,0,0,0,0,0,0}; //last digit stores length of the number
	
	int length = num==0?1:0;
	
	while(num >= 1)
	{
		int nextDig = num % 10;
		numArr[nextDig]++;
		num = num/10;
		length++;
	}
	numArr[10] = length;
	return numArr;
}

}
