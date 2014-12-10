import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class BeautyOfString {

	public static void main(String []args){
			
			BufferedReader br;
			try{
				File f = new File(args[0]);
				br = new BufferedReader(new FileReader(f));
				String next = br.readLine();
				while(next != null)
				{
					System.out.println(calcBeauty(next.toLowerCase()));
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

	private static int calcBeauty(String next) {
		
		//populate array with frequencies
		
		Node[] listOfFreqs = getListWithFrequesncies(next);
		
		Node[] sortedList = mergeSort(listOfFreqs,0,25);
		
		int beauty = 0;
		int index = 26;
		for(Node n: sortedList)
		{
			if(n == null)
				break;
			
			beauty += index*n.freq;
			index--;
		}
		
		return beauty;
	}

	private static Node[] mergeSort(Node[] listOfFreqs,int start,int end) {
		//perform merge sort
		Node [] merged = new Node[1];
		if(start == end){
			merged[0] = listOfFreqs[start];
			return merged;
		}
		
		Node[] left = mergeSort(listOfFreqs,start,(start+end)/2);
		Node[] right = mergeSort(listOfFreqs,(start+end)/2+1,end);
		return merge(left,right);
	
	}

	private static Node[] merge(Node[] left, Node[] right) {
		
		Node merged[] = new Node[left.length + right.length];
		int lPos = 0, rPos = 0,count =0;
		
		while(lPos < left.length || rPos < right.length){
			
			if(lPos == left.length)
				{
					merged[count] = right[rPos];
					rPos ++;
					count++;
					continue;
				}
			
			if(rPos == right.length)
			{
				merged[count] = left[lPos];
				lPos++;
				count++;
				continue;
			}
			
			if(isLeftGreater(left[lPos], right[rPos])){
					merged[count] = left[lPos];
					lPos++;
				}
			else {
					merged[count] = right[rPos];
					rPos++;
				}
			count ++;
		}
		
		return merged;
	}

	private static boolean isLeftGreater(Node left, Node right) {
		
		if(left == null)
			return false;
		if(right == null)
			return true;
		
		if(left.freq >= right.freq)
			return true;
		return false;
	}

	private static Node[] getListWithFrequesncies(String next) {
		Node [] freqList = new Node[26]; //each alphabet corresponding to its number
		
		char [] myString = next.toCharArray();
		
		for(char c:myString) {
			
			if(c >= 97 && c <= 122){
				if(freqList[c-97] == null)
						freqList[c-97] = new Node(c);
				freqList[c-97].incrFreq();
			}
					
		}
		
		
		return freqList;
	}

	private static class Node {
		
		char myChar;
		int freq;
		
		Node(char myChar)
		{
			this.myChar = myChar;
			this.freq = 0;
		}
		
		void incrFreq()
		{
			this.freq ++;
		}
		
	}
}
