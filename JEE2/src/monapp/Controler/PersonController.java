package monapp.Controler;

import javax.faces.bean.SessionScoped;

import monapp.model.Activitie;
import monapp.model.Person;
import monapp.services.PersonEJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@ManagedBean(name = "PersonController")
@SessionScoped
public class PersonController {
	
	private List<Person> listPerson = new ArrayList<Person>();
	Person thePerson = new Person();
	List<Activitie> activities = new ArrayList<Activitie>();
    Activitie TheActivitie;
    
	@EJB
	private PersonEJB personEjb;
	
	public List<Person> fct() {
		if (personEjb == null) {
			System.out.println("bigprob");
		}
		listPerson = personEjb.getPersons();
		return listPerson;
	}
	
	public Person getThePerson(){
		return thePerson;
	}
	
	public void setThePerson(Person person){
		this.thePerson = person;
	}
	
	public String show(String mail) {
        thePerson = personEjb.findPerson(mail);
        return "Person";
    }

	public List<Person> getListPerson() {
		return listPerson;
	}

	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}
	
	public List<Activitie> ListActivities()
    {
    	activities = thePerson.getCv().getActivities();
    	return activities;
    }
	
	

}
