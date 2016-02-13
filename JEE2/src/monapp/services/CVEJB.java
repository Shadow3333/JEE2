package monapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import monapp.model.Activitie;
import monapp.model.CV;

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
	
	public void saveActivitie(Activitie activ) {
		try {
//			for (Activitie activ : cv.getActivities()) {
//				em.merge(activ);
//				System.out.println("saved activitie " + activ.getTitre());
//			}
			em.merge(activ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveCV(CV cv) {
		try {
//			for (Activitie activ : cv.getActivities()) {
//				em.merge(activ);
//				System.out.println("saved activitie " + activ.getTitre());
//			}
			em.merge(cv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addCV(CV cv) {
		try {
			cv.setActivities(new ArrayList<Activitie>());
			em.persist(cv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CV> getCVs()
	{
		TypedQuery<CV> q = em.createQuery("FROM CV", CV.class);
		return q.getResultList();
	}
}
