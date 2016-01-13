package springapp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import springapp.model.CV;
import springapp.model.Person;

public class CVDAO implements ICVDAO{

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tr;
	
	public static void start()
	{
		if (emf == null || emf.isOpen() == false) {
			emf = Persistence.createEntityManagerFactory("Annuaire");			
		}
		em = emf.createEntityManager();
		tr = em.getTransaction();
	}
	
	public static void end()
	{
		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}
	
	public void saveCV(CV cv) {
		start();
		try {
			tr.begin();
			em.merge(cv);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (em != null) {
				end();
			}
		}
		
	}
	
}
