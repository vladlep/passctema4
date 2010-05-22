import java.util.List;


public interface DataAccessObject 
{
	//DataAccessObject - din paternul DAO
	List loadList ();
	void storeList(List lista);
}
