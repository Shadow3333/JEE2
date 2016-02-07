package monapp.services;

import monapp.model.Person;

/**
 * 
 * @author Frederic and Mariana
 *
 */
public interface IPersonEJB {

   // lire une personne
	public Person findPerson(String mail);
	
	// modification ou ajout d'une nouvelle personne
	public void savePerson(Person p);
	
	// enlever une personne
	public void remove(Person p);
	   
	   
}
