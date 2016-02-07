package springapp.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import springapp.model.Activitie;
import springapp.model.CV;
import springapp.model.Person;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Stateless(name = "cvEJB")
@Local
public class CVEJB implements ICVEJB{

	@PersistenceContext
	private static EntityManager em;
	
	public void saveCV(CV cv) {
		try {
			em.merge(cv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
