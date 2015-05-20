package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the encapsulating class for all seating chart items 
 * @author Mouleendhra
 *
 */
public class Item {
	/**
	 * This is an internal class that is used to number items
	 * @author Mouleendhra
	 *
	 */
	static class ItemNumberer{
		static int curItemNum = 0;
		static String fileName = "data.txt";
		
		
		private static String openFile(String fileName){
			String line = "";
			 try {
		            FileReader fileReader = new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            line = bufferedReader.readLine();              
		            bufferedReader.close();            
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");                
		        } catch (IOException e) {
					e.printStackTrace();
				}			
			return line;
		}
		
		public static  int getItemNum(){
			if(curItemNum == 0){
				String line = openFile(fileName);
				//this check allows for empty files
				if(line == null || line == "" || !line.contains("Item Number"))
					return 0;
				//14 is the index number following "Item Number: "
				curItemNum = Integer.parseInt(line.substring(14));
			}
			int temp = curItemNum;
			curItemNum++;
			return temp;
		}
		
		public static int editItemNum(int newNum){
			int temp = curItemNum;
			curItemNum = newNum;
			return temp;
		}
		
		public static int save(){
			try {
	            FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            bufferedWriter.write("Item Number: ");
	            bufferedWriter.write(curItemNum);
	            bufferedWriter.newLine();
	            // Always close files.
	            bufferedWriter.close();
	            return 0;
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"
	                + fileName + "'");
	            return 1;
	        }
		}
	}
	
	public int itemNumber;
	public int x;
	public int y;
	public int size;
	
	public Item(){
		this.x = 0; this.y = 0; this.size = 0; itemNumber = ItemNumberer.getItemNum();
	}
	
	
}
