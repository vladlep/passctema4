import java.io.*;
import java.util.ArrayList;

public class XSDSchemaParser 
{
	private String path;
	
	public void parseSchema()
	{
		
		File inFile = new File(path);	
		BufferedReader fin = null;
		String buff;
		ArrayList<String> claseCreate = new ArrayList<String>();
		ArrayList<String> parametriConstrucotr = new ArrayList<String>();
		try 
		{
			fin = new BufferedReader( new FileReader(inFile) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		try {
			while ((buff = fin.readLine()) != null)
			{
				System.out.print(buff+"\n");
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
