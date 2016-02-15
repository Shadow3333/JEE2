package monapp.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import monapp.model.Activitie;
import monapp.model.CV;
import monapp.model.Login;
import monapp.model.Person;
import monapp.utilitaire.Hash;

@Stateful(name="ConnectedUser")
public class ConnectedUser {
	
	@EJB
	private PersonEJB personEjb;
	private static Person person;
	
	@PersistenceContext(unitName = "Jee2BD")
	private EntityManager em;
	
	@PostConstruct
	public void construct(){}
	
	public boolean login(String mail, String pwd) {
		pwd = Hash.getEncodedPassword(pwd);
		TypedQuery<Login> q = em.createQuery("FROM Login where mail = '" + mail+"'", Login.class);
		if (!q.equals(null) && 
		     q.getSingleResult().getPassword().equals(pwd) ) {
			person = personEjb.findPerson(mail);
			return true;
		}
		return false;
	}
	
	public void logout() {
		person = null;
	}
	
	public void addLogin(String mail, String pwd)
	{
		Login logs = new Login(mail, pwd);
		em.merge(logs);
	}
	
	public Login findLogin(String mail)
	{
		TypedQuery<Login> q = em.createQuery("FROM Login where mail = '" + mail+"'", Login.class);
		return q.getResultList().isEmpty() ? null : q.getSingleResult();
		
	}

	public void removeLogin(String mail)
	{
		Login logs = findLogin(mail);
		em.remove(em.contains(logs) ? logs : em.merge(logs));
	}
	
	public static Person getCurrUser()
	{
		return person;
	}
	
	public void addActivitie(Activitie activ) {
		try {
			CV cv = person.getCv();
			cv.addActivitie(activ);
			em.persist(em.merge(cv));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeActivitie(Activitie activ) {
		try {
			CV cv = person.getCv();
			cv.removeActivitie(activ);
			em.merge(cv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void majActivitie(Activitie activ) {
		try {
			em.merge(activ);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveUser(Person person)
	{
		try {
			em.merge(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}