import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class QueryRunner{
	
	public static void main(String []args){
		
		QueryBoard board = new QueryBoard();
		board.init();
		BufferedReader br;
		try{
			File f = new File(args[0]);
			br = new BufferedReader(new FileReader(f));
			String next = br.readLine();
			while(next != null)
			{
				
				if(!next.trim().equals(""))
				{	
					board.callOperation(next.trim());
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
	
	


	private static class QueryBoard {

	private int sumOfRow[];
	private int sumOfCol[];
	private Operation []rowOp;
	private Operation []colOp;
	
	public void init() {
		sumOfRow = initialize(0,256);
		sumOfCol = initialize(0,256);
		rowOp = new Operation[256];
		colOp = new Operation[256];
	}

	public void callOperation(String next) {
		
		String params[] = next.split(" ");
		String op = params[0];
		
		switch(op) {
		
		case "SetRow" :
			setRow(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
			break;
			
		case "SetCol" :
			setCol(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
			break;
			
		case "QueryRow" :
			System.out.println(queryRow(Integer.parseInt(params[1])));
			break;
			
		case "QueryCol" :
			System.out.println(queryCol(Integer.parseInt(params[1])));
			break;
		
		
		}
		
	}

	public void setRow(int rowNum, int val){
		//set row's sum
		sumOfRow[rowNum] = val*sumOfRow.length;
		//set column's sums
		manipulateCol(val,rowNum);
		//set operation
		rowOp[rowNum] = new Operation(val);
		
	}
	
	public void setCol(int colNum, int val){
		//set col's sum
		sumOfCol[colNum] = val*sumOfCol.length;
		//set rows' sums
		manipulateRow(val,colNum);
		//set operation
		colOp[colNum] = new Operation(val);
		
	}

	private void manipulateCol(int newVal, int rowNum) {
		
		for(int i=0;i<sumOfCol.length;i++)
		{
			int prevVal = getPrevVal(rowNum,i);
			sumOfCol[i] = sumOfCol[i] - prevVal + newVal;
		}
		
	}

	private void manipulateRow(int newVal, int colNum) {
		
		for(int i=0;i<sumOfRow.length;i++)
		{
			int prevVal = getPrevVal(i,colNum);
			sumOfRow[i] = sumOfRow[i] - prevVal + newVal;
		}
		
	}

	private int getPrevVal(int rowNum, int colNum) {
		if(rowOp[rowNum] == null && colOp[colNum] == null)
		return 0;
		
		if(rowOp[rowNum] == null)
			return colOp[colNum].value;
		
		if(colOp[colNum] == null)
			return rowOp[rowNum].value;
		
		//return most recent value
		return rowOp[rowNum].timeStamp>colOp[colNum].timeStamp?rowOp[rowNum].value:colOp[colNum].value;
		
	}

	public int queryRow(int row){
		return sumOfRow[row];
	}
	
	public int queryCol(int col){
		return sumOfCol[col];
	}

	private int[] initialize(int val, int size) {
		
		int [] array = new int[size];
		for(int i=0;i<array.length;i++)
		{
			array[i] = val;
		}
		return array;
		
		
	}
}

	private static class Operation{
	static int counter= 0;
	int value;
	int timeStamp;
	
	Operation(int value){
		this.value = value;
		this.timeStamp = counter;
		counter ++;
	}
}
}
