package monapp.tests;

import static org.junit.Assert.*;

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
	@Ignore
	public void testFindPerson() {
		assertNotNull(personEjb.findPerson("john@gmail.com"));
	}

	@Test
	public void testSavePerson() {
		CV cv = new CV();
		person1 = new Person("Smith", "john", "john@gmail.com", cv);
		personEjb.savePerson(person1);
	}

	@Test
	@Ignore
	public void testRemove() {
		fail("Not yet implemented");
	}

}
