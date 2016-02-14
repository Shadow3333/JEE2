package monapp.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import monapp.model.CV;
import monapp.model.Person;
import monapp.services.CVEJB;
import monapp.services.PersonEJB;

public class PersonEJBTest {
	
	private static EJBContainer ejbContainer;
	private static PersonEJB personEjb;
	private static Person person1;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer();
		
	}
	
	@Before
	public void lookup() throws NamingException {
		Object object = ejbContainer.getContext().lookup("java:global/JEE2/PersonEJB");
		
		assertTrue(object instanceof PersonEJB);
		
		personEjb = (PersonEJB) object;
		
		Object object2 = ejbContainer.getContext().lookup("java:global/JEE2/CVEJB");
		
		assertTrue(object2 instanceof CVEJB);
	}

	@AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

	@Test
	public void testFindPerson() {
		CV cv = new CV();
		person1 = new Person("Smithbl", "johnbl", "bla@gmail.com", cv);
		personEjb.savePerson(person1);
		assertNotNull(personEjb.findPerson("bla@gmail.com"));
	}

	@Test
	public void testSavePerson() {
		CV cv = new CV();
		person1 = new Person("Smith", "john", "john@gmail.com", cv);
		personEjb.savePerson(person1);
	}

	@Test
	public void testRemove() {
		CV cv = new CV();
		person1 = new Person("SmithRem", "johnRem", "Rem@gmail.com", cv);
		personEjb.savePerson(person1);
		Person personDe = personEjb.findPerson("Rem@gmail.com");
		personEjb.remove(personDe);
	}
	
	@Test
	public void testGetPersons(){
		CV cv = new CV();
		person1 = new Person("SmithRem", "johnRem", "Rem@gmail.com", cv);
		personEjb.savePerson(person1);
		List<Person> list = personEjb.getPersons();
		System.out.println(list.size());
		assertNotNull(list.size());
	}

}
