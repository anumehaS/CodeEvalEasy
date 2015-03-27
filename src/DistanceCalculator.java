import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DistanceCalculator {

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
					printDist(next.trim());
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

private static void printDist(String next) {
	
	//(25, 4) (1, -6)
	String points[] = (next.trim().substring(1, next.length()-1)).split("\\) \\(");
	Point p1 = new Point(points[0].trim()); //25, 4
	Point p2 = new Point(points[1].trim()); //1, -6
	
	System.out.print((int)p1.calcDist(p2));
}

private static class Point{
	
	int x,y;
	Point(String coordinates){
		String points[] = coordinates.split(",");
		String xPoint = points[0].trim();
		String yPoint = points[1].trim();
		
		this.x = getPointFromString(xPoint);
		this.y = getPointFromString(yPoint);
	}
	
	private int getPointFromString(String point) {
		
		boolean isPositive = true;
		if(point.charAt(0) == '-'){
			isPositive = false; 
			point = point.substring(1);
		}
		
		return isPositive?Integer.parseInt(point):-1*Integer.parseInt(point);
	}
	
	double calcDist(Point p1) {
		int xDist = p1.x - this.x;
		int yDist = p1.y - this.y;
		
		double dist = Math.pow(Math.pow(xDist, 2) + Math.pow(yDist, 2),0.5);
		
		return dist;
	}
	
}
}
