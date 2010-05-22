import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Horoscop 
{
	private ArrayList<Student> list;
	private DataAccessObject dataSursa;
	
	public Horoscop(DataAccessObject d)
	{
		list = new ArrayList<Student>();
		dataSursa = d;
	}
	
	public void changeSource(DataAccessObject newSource)
	{
		dataSursa = newSource; 
	}
	
	public void loadList()
	{
		list = (ArrayList<Student>) dataSursa.loadList();
	}

	public void printList() 
	{
		System.out.println(list.toString());
		
	}
	public Student findByNr_matr(int nr_matr)
	{
		Iterator<Student> it = list.iterator();
		Student aux;
		while(it.hasNext())
		{
			if( (aux = it.next()).getNr_matr() == nr_matr)
			{
				//System.out.println(aux.toString());
				return aux;
			}
			
		}
	
		return null;
		
	}
	
	public List<Student> findByMedie(double medie)
	{
		Iterator<Student> it = list.iterator();
		Student aux;
		ArrayList result = new ArrayList<Student>();
		
		while(it.hasNext())
		{
			if( (aux = it.next()).getMedie() == medie)
			{
				//System.out.println(aux.toString());
				result.add(aux);
			}
			
		}
	
		return result;
		
	}
	
	public int catiVorAveaMediaScazuta()
	{
		Iterator<Student> it = list.iterator();
		int contor = 0;
		Student aux;
		while(it.hasNext())
		{
			aux = it.next();
			if( aux.getMedie() >8 && !aux.cresteMedia() )
				contor++;
		}
		
		return contor;
	}
}
