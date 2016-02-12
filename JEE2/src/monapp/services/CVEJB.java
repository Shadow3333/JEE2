package monapp.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import monapp.model.Activitie;
import monapp.model.CV;
import monapp.model.Person;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Stateless
@Local
public class CVEJB{

	@PersistenceContext(unitName = "Jee2BD")
	private EntityManager em;
	
	public void saveCV(CV cv) {
		try {
			em.persist(cv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
