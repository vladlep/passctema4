 import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student 
{
	
	// e un transfer object din DAO
	private int nr_matr;
	private String nume;
	private double medie;
	
	public Student(int nr_matr, String nume, double medie)
	{
		this.nr_matr = nr_matr;
		this.nume = nume;
		this.medie = medie;
		
	}
	
	public int getNr_matr()
	{
		return nr_matr;
	}
	
	public double getMedie()
	{
		return medie;
	}
	
	public String toString()
	{
		return nr_matr+" "+nume+" : "+medie+"\n";
	}
	
	public boolean cresteMedia()
	{
		int i, aux =1;
		int result= 0;
		for (i=0; i < nume.length(); i++)
		{
			result =  (result + nume.charAt(i)) %2;
		//	System.out.println(result);
		}
		for(i=0;i< String.valueOf(nr_matr).length(); i++)
		{
			result = (result + (nr_matr/ aux)%20) %2;
			aux *= 10;
			//System.out.println("2 for "+result);
		}
		if(result == 1)
			return true;
		return false;
	}

	public boolean vaFiZiuaBuna() 
	{
		int result =0;
		result = nume.charAt(0)%2;
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date data = new Date(); 
	//	System.out.println("data " + (Integer.valueOf(dateFormat.format(data))));
		result = (result +(Integer.valueOf(dateFormat.format(data))) ) %2;
	//	System.out.println("result " + result);
		if(result == 1) 
			return true;
		return false;
	}
	
}
