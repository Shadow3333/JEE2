package monapp.Controler;

import javax.faces.bean.SessionScoped;

import monapp.model.Person;
import monapp.services.ConnectedUser;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "ConnectedController")
@SessionScoped
public class ConnectedController {
	
	@EJB
	private ConnectedUser ejbUser;
	
	private Person person;
	
	public Person getPerson()
	{
		person = ConnectedUser.getCurrUser();
		if(person == null)
		{
			person = new Person();
			person.setMail("Unlogged");
		}
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
