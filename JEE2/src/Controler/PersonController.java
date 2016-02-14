package Controler;

import javax.faces.bean.SessionScoped;

import monapp.model.Person;
import monapp.services.PersonEJB;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "course")
@SessionScoped
public class PersonController {
	
	@EJB
	private PersonEJB personEjb;
	
	Person thePerson = new Person();
	
	public List<Person> getPersons(){
		return personEjb.getPersons();
	}
	
	public Person getThePerson(){
		return thePerson;
	}
	
	public String show(String mail) {
        thePerson = personEjb.findPerson(mail);
        return "showCourse";
    }

}
