import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


public class SimpleSort {


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
					printSorted(next.trim());
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

private static void printSorted(String next) {
	
	String allNums [] = next.split(" ");
	
	double merged[] = mergeSort(allNums,0,allNums.length-1);
	boolean first = true;
	for(double d: merged){
		
		DecimalFormat df = new DecimalFormat("#.000");
		
		if(first)
			{System.out.print(df.format(d));
				first=false;
			}
		else
			System.out.print(" "+df.format(d));
		
	}
}

private static double[] mergeSort(String[] allNums, int start, int end) {
	
	if(start == end)
	{
		double [] arr = {Double.parseDouble(allNums[start])};
		return arr;
	}
	
	double left[] = mergeSort(allNums, start, (start+end)/2);
	double right[] = mergeSort(allNums, ((start+end)/2)+1, end);
	
	return merge(left,right);
}

private static double[] merge(double[] left, double[] right) {
	double []merged = new double[left.length + right.length];
	
	int count=0, lPos =0, rPos =0;
	while(lPos < left.length || rPos < right.length) {
		
		if(lPos == left.length)
		{
			merged[count] = right[rPos];
			rPos ++;
			count ++;
			continue;
		}
		
		if(rPos == right.length)
		{
			merged[count] = left[lPos];
			lPos ++;
			count ++;
			continue;
		}
		
		if(left[lPos] <= right[rPos]) {
			merged[count] = left[lPos];
			lPos ++;
			
		} else {
			
			merged[count] = right[rPos];
			rPos ++;
		}
		
		count++;
	}
	
	return merged;
}

}
