package springapp.DAO;

import springapp.model.Person;

/**
 * 
 * @author Frederic and 
 *
 */
public interface IPersonDAO {

   // lire une personne
	public Person findPerson(Integer id);
	
	// modification ou ajout d'une nouvelle personne
	public void savePerson(Person p);
	
	// enlever une personne
	public void remove(Person p);
	   
	   
}
