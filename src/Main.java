
public class Main 
{
	public static void main(String args[])
	{
	Horoscop h = new Horoscop(new XMLReader());
	
	h.loadList();
	
	System.out.print("we are\n\n\n");
	h.printList();
	System.out.println("studentul cu nr matr 2 : "+ h.findByNr_matr(2).toString());
	System.out.println("studentii cu nr media 8 : "+ h.findByMedie(8).toString());
	System.out.println("ii creste studentului media ? "+ h.findByNr_matr(5).cresteMedia());
	System.out.println("ii creste studentului media ? "+ h.findByNr_matr(6).cresteMedia());
	System.out.println("cati studenti cu M >8 vor avea media scazuta? "+ h.catiVorAveaMediaScazuta());
	System.out.println("va avea studentul numarul 3 o zi buna ?"+h.findByNr_matr(3).vaFiZiuaBuna());
	
	
	System.exit(0);
	}
	
}
