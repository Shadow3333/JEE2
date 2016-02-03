package springapp.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import springapp.services.ConnectedUser;
import springapp.services.PersonEJB;

@Stateful(name="connectedUser")
public class ConnectedUserBean implements ConnectedUser {

	private String m_login;
	
	@EJB
	private PersonEJB Pers;
	
	@PostConstruct
	public void construct()
	{
		System.out.println("Déb");
	}
	
	public void login(String login, String pwd) {
		System.out.println("Nous confirmant votre mot de pass : " + pwd);
		m_login = login;
		System.out.println("Utilisateur "+ m_login + " bien authentifié !");
	}

	@PreDestroy
	public void fin() {
		System.out.println("Stopping " + this);
	}
	
	@Remove
	public void logout() {
		System.out.println("Bye Bye Mr." + m_login + " !");
		
	}

}