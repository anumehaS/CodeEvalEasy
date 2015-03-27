import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LongestWord {

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
						printLongestWord(next.trim());
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

	private static void printLongestWord(String next) {
		
		String []allWords = next.split(" ");
		
		int longestLength = 0;
		String longestWord = "";
		
		for(String word:allWords)
		{
			if(word.length() > longestLength)
				{
					longestLength = word.length();
					longestWord = word;
				}
		}
		
		System.out.println(longestWord);
	}

}

