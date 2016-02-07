package springapp.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import springapp.model.Person;

/**
 * 
 * @author Frederic and Mariana
 *
 */

@Stateless(name = "personEJB")
@Local
public class PersonEJB implements IPersonEJB{

	@PersistenceContext
	private static EntityManager em;
	
	/**
	 * finds a person by id
	 */
	public Person findPerson(Integer id) {
		try {
			return em.find(Person.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * saves a person in the database
	 */
	public void savePerson(Person p) {
		try {
			em.merge(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * removes a person from the database
	 * @param p
	 */
	public void remove(Person p)
	{
		try {
			em.remove(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}