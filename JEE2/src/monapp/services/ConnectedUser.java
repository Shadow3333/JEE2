package monapp.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import monapp.model.Login;
import monapp.model.Person;

@Stateful(name="ConnectedUser")
public class ConnectedUser {
	
	@EJB
	private PersonEJB personEjb;
	private Person person;
	
	@PersistenceContext(unitName = "Jee2BD")
	private EntityManager em;
	
	@PostConstruct
	public void construct()
	{
	}
	
	public boolean login(String mail, String pwd) {
		TypedQuery<Login> q = em.createQuery("FROM Login where mail = '" + mail+"'", Login.class);
		if (!q.equals(null) && 
		     q.getSingleResult().getPassword().equals(pwd) ) {
			person = personEjb.findPerson(mail);
			return true;
		}
		return false;
	}
	
	@Remove
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
	
}