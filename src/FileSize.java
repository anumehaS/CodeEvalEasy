import java.io.File;


public class FileSize {

	public static void main(String []args) {
		
		try{
			
			File f = new File(args[0]);
			System.out.println(f.length());
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
