package CSET151LabExam2019;
import java.io.*;
import java.text.*;
import java.util.*;
import static CSET151LabExam2019.Constants.*;

public class StudentList
{
	
	public  static String LoadData(){
		System.out.println("Loading data ...");
		String contents = null;
		try {
			BufferedReader fileStream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			 contents = fileStream.readLine();
		} catch (Exception e){

		}
		return  contents;
	}
	
	public  static  void  WirteData(String[] args){
		System.out.println("Loading data ...");
		try {
			String reader = LoadData();
			FileWriter s = new FileWriter("students.txt");  
			BufferedWriter buffer = new BufferedWriter(s);  
    
			String t = args[0].substring(1);
			Date d = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
			String fd= dateFormat.format(d);
			s.write(reader+", "+t+"\nList last updated on "+fd);
			s.close();
		} catch (Exception e){}

		System.out.println("Data Loaded.");
	}

	public static void main(String[] args) 
	{
		//Constants constants = new Constants();
//		Check arguments
		if(args == null || args.length!=1)
		{
			System.out.println("Please enter a|r| c | +WORD | ?WORD");	
			return;
		}
		String reader = LoadData();
		if(args[0].equals(ShowAll)) 
		{
			 
				
				String words[] = reader.split(",");			
				for(String word : words) 
				{ 
					System.out.println(word); 
				}
			 
			
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals(ShowRandom))
		{
			
				String words[] = reader.split(",");	
				Random rand = new Random();
				int randomIndex = rand.nextInt(words.length);
				System.out.println(words[randomIndex]);
			
			
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains(AddEntry))
		{
			WirteData(args);
		}
		else if(args[0].contains(FindEntry)) 
		{
			System.out.println("Loading data ...");			
			
				String words[] = reader.split(",");	
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<words.length && !done; idx++) 
				{
					if(words[idx].equals(t)) 
					{
						System.out.println("We found it!");
						done=true;
					}
				}
			
			
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains(ShowCount)) 
		{
			System.out.println("Loading data ...");			
			
							
				String words[] = contents.split(",");
			char a[] = contents.toCharArray();
			System.out.println(words.length +" word(s) found Character" + a.length);
			
			
			System.out.println("Data Loaded.");				
		}
		else
		{
			System.out.println("enter right arguments");
		}
		
	}
}