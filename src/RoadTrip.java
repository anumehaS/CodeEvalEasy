import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class RoadTrip {


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
					findDistances(next.trim());
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

private static void findDistances(String next) {
	
	String allDistances [] = next.split(";");
	
	//sort distances in increasing order of lengths
	int [] sortedDistances = mergeSort(allDistances,0,allDistances.length -1);
	
	System.out.print(sortedDistances[0]);
	int prev = sortedDistances[0];
	for(int i =1; i< sortedDistances.length;i++){	
		System.out.print(","+(sortedDistances[i] - prev));
		prev = sortedDistances[i];
	}
	
}

private static int[] mergeSort(String[] allDistances, int start, int end) {
	
	if(start == end) { 
		if(allDistances[start].equals(""))
			return new int[0];
		
		String temp[] = allDistances[start].split(",");
		int returnVal [] = {Integer.parseInt(temp[1])};
		return returnVal;
	}
	int mid = (start + end) /2;
	int [] left = mergeSort(allDistances, start, mid);
	int [] right = mergeSort(allDistances, mid+1,end);
	
	
	return merge(left,right);
}

private static int[] merge(int[] left, int[] right) {
	
	int total = left.length+right.length;
	int merged [] = new int[total]; 
	
	int lPos =0, rPos =0;
	for(int i =0; i< total; i++) {
		
		if(lPos == left.length)
		{
			merged[i] = right[rPos];
			rPos++;
		}
		else if(rPos == right.length)
		{
			merged[i] = left[lPos];
			lPos++;
		}
		else
			if(left[lPos] <= right[rPos])
				{
					merged[i] = left[lPos];
					lPos++;
				} else {
					merged[i] = right[rPos];
					rPos++;
				}
	}
	
	return merged;
}

}
