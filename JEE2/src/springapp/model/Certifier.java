package springapp.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import springapp.services.Authenticator;
import springapp.services.PersonEJB;

@Stateful(name="Certifier")
public class Certifier implements Authenticator {
	
	@EJB
	private PersonEJB Pers;
	
	@PersistenceContext
	private static EntityManager em;
	
	@PostConstruct
	public void construct()
	{
		System.out.println("Déb");
	}
	
	public boolean login(String mail, String pwd) {
		TypedQuery<Login> q = em.createQuery("FROM Login where mail = '" + mail+"'", Login.class);
		
		if (!q.equals(null) && 
		     q.getSingleResult().getPassword() == pwd ) {
			System.out.println("Check succes");
			return true;
		}
		return false;
	}
	
	@Remove
	public void logout() {
		System.out.println("logout");
	}

}