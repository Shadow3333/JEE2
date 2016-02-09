package monapp.tests;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monapp.model.Person;
import monapp.services.PersonEJB;

public class PersonEJBTest {
	
	private static EJBContainer ejbContainer;
	private static PersonEJB personEjb;
	private static Person person1;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer();
		person1 = new Person("Smith", "john", "john@gmail.com");
	}
	
	@Before
	public void lookup() throws NamingException {
		personEjb = (PersonEJB) ejbContainer.getContext().lookup("java:global/JEE2/PersonEJB");
	}

	@AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

	@Test
	public void testFindPerson() {
		assertNotNull(personEjb.findPerson("john@gmail.com"));
	}

	@Test
	public void testSavePerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

}
