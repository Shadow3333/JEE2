package monapp.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import monapp.model.Person;

/**
 * 
 * @author Frederic and Mariana
 *
 */

@Stateless
@Local
public class PersonEJB {

	@PersistenceContext(unitName = "Jee2BD")
	private EntityManager em;
	
	/**
	 * finds a person by id
	 */
	public Person findPerson(String mail) {
		try {
			return em.find(Person.class, mail);
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
			em.remove(em.contains(p) ? p : em.merge(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
