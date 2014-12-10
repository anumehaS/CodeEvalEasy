
public class MultiplicationTables {

	
	public static void main(String []args) {
		
		for(int i =1; i<=12; i++){
			
			generateTable(i);
			System.out.println();
		}	
}



static void generateTable(int number) {
	
	for(int i=1;i<=12;i++) {
		
		int product = i*number;
		int length = numDigits(product);
		
		String space; //two spaces
		
		if(i==1 && length == 1)
			space = " ";
		else if(i==1 && length ==2)
			space = "";
		else{
			switch(length) {
				case 1: 
					space = "   ";
					break;
				case 3:
					space = " ";
					break;
				default:
					space ="  ";
					break;
				
			}
		}
		
		System.out.print(space+product);
	}
	
}

static int numDigits(int number) {
	int length = String.valueOf(number).length();
	return length;
}
}