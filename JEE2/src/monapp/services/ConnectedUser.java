package monapp.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import monapp.model.Login;

@Stateful(name="ConnectedUser")
public class ConnectedUser {
	
	@EJB
	private PersonEJB Pers;
	
	@PersistenceContext(unitName = "Jee2BD")
	private EntityManager em;
	
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
	
	public void addLogin(String mail, String pwd)
	{
		Login logs = new Login(mail, pwd);
		em.merge(logs);
	}
	
	public Login findLogin(String mail)
	{
		TypedQuery<Login> q = em.createQuery("FROM Login where mail = '" + mail+"'", Login.class);
		return q.getSingleResult();
		
	}

	public void removeLogin(String mail)
	{
		Login logs = findLogin(mail);
		em.remove(logs);
	}
	
}