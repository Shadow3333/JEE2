package Controler;

import javax.faces.bean.SessionScoped;

import monapp.model.Person;
import monapp.services.PersonEJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "PersonController")
@SessionScoped
public class PersonController {
	
	private List<Person> listPerson = new ArrayList<Person>();
	Person thePerson = new Person();
	
	@EJB
	private PersonEJB personEjb;
	
	public void init() {
		if (personEjb == null) {
			System.out.println("bigprob");
		}
		System.out.println("et il passera par la");
		listPerson = personEjb.getPersons();
//		List<Person> list = personEjb.getPersons();
//		for (int i = 0; i < list.size(); i ++){
//			listPerson.add(personEjb.getPersons().get(i));
//		}

	}
	
	public List<Person> fct() {
		if (personEjb == null) {
			System.out.println("bigprob");
		}
		System.out.println("et il passera par la");
		return listPerson = personEjb.getPersons();
//		List<Person> list = personEjb.getPersons();
//		for (int i = 0; i < list.size(); i ++){
//			listPerson.add(personEjb.getPersons().get(i));
//		}

	}
	
	public Person getThePerson(){
		return thePerson;
	}
	
	public String show(String mail) {
        thePerson = personEjb.findPerson(mail);
        return "showCourse";
    }
	
	public String newPerson(){
		thePerson = new Person();
		return "Person";
	}

	public List<Person> getListPerson() {
		return listPerson;
	}

	public void setListPerson(List<Person> listPerson) {
		this.listPerson = listPerson;
	}
	

}
