import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.*;


public class SumOfJsonIds {
	

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
					printSumOfIds(next.trim());
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

private static void printSumOfIds(String next) {
	int sumOfIds = 0;
	try {
		JSONObject myJson = new JSONObject(next);
		if(myJson != null)
		{
			JSONObject menu = myJson.getJSONObject("menu");
			JSONArray items = menu.getJSONArray("items");
			
			if(items!= null)
			{	JSONObject obj;
				for(int i =0; i<items.length();i++) {
					
					try {
						obj = items.getJSONObject(i);
						if(obj != null && obj.has("label"))
						{
							sumOfIds += obj.getInt("id");
						}
					}catch(JSONException e){
						
					}
						
				}
					
			}
				
			
			
		}
		
	} catch (JSONException e) {
		e.printStackTrace();
	}
	
	System.out.println(sumOfIds);
}


}
