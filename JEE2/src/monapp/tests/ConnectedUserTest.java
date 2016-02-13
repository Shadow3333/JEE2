package monapp.tests;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import monapp.model.Login;
import monapp.services.CVEJB;
import monapp.services.ConnectedUser;
import javax.naming.Context;

public class ConnectedUserTest {
	
	private static Context ejbContainer;
	private ConnectedUser connectedUser;
	private static Login login;
	private static Login loginRemove;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer().getContext();
		login = new Login("mail@mail.fr","aze");
		loginRemove = new Login("remove@mail", "a");
	}
	
	@Before
	public void lookup() throws NamingException {
		connectedUser = (ConnectedUser) ejbContainer.lookup("java:global/JEE2/ConnectedUser");
	}

	@AfterClass
    public static void stopTheContainer() throws NamingException {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

	@Test
	@Ignore
	public void testConstruct() {
		connectedUser.construct();
	}

	@Test
	@Ignore
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testLogout() {
		connectedUser.logout();
	}

	@Test
	@Ignore
	public void testAddLogin() {
		connectedUser.addLogin("mail@mail.fr", "aze");
	}

	@Test
	public void testFindLogin() {
		Login findLogin =  connectedUser.findLogin("mail@mail.fr");
		assertEquals(login.getMail(), findLogin.getMail());
		assertEquals(login.getPassword(), findLogin.getPassword());
	}

	@Test
	public void testRemoveLogin() {
		connectedUser.addLogin("remove@mail", "a");
		connectedUser.removeLogin("remove@mail");
		assertNull(connectedUser.findLogin("remove@mail"));
	}

}
