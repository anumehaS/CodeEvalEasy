import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;


public class DataRecovery {

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
					recoverData(next.trim());
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

private static void recoverData(String next) {
	
	String temp[] = next.split(";");
	String positions[] = temp[1].split(" ");
	String words [] = temp[0].split(" ");
	
	String recovered[] = new String[words.length];
	
	HashSet<Integer> allPositions = new HashSet<Integer>();
	initialize(allPositions,words.length);
	
	for(int i=0;i<positions.length;i++) {
		
		int pos = Integer.parseInt(positions[i]);
		recovered[pos-1] = words[i]; 
		
		if(allPositions.contains(pos-1))
			allPositions.remove(pos-1);
	}
	
	Iterator<Integer> itr = allPositions.iterator();
	
	int remainingPos = positions.length;
	while(itr.hasNext()){
		
		recovered[itr.next()] = words[remainingPos];
	}
	
	
	print(recovered);
}

private static void initialize(HashSet<Integer> allPositions, int length) {
	for(int i =0;i<length;i++)
	{
		allPositions.add(i);
	}
	
}

private static void print(String[] recovered) {
	
	for(String word: recovered){
		System.out.print(word+" ");
	}
	
}
}
