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
import monapp.services.ConnectedUser;
import monapp.utilitaire.Hash;

import javax.naming.Context;

/**
 * 
 * @author Frederic and Mariana
 *
 */
public class ConnectedUserTest {
	
	private static Context ejbContainer;
	private ConnectedUser connectedUser;
	private static Login login;
	private static Login loginRemove;
	private static String mdp;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer().getContext();
		mdp = Hash.getEncodedPassword("aze");
		login = new Login("mail@mail.fr",mdp);
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
	public void testConstruct() {
		connectedUser.construct();
	}

	@Test
	public void testLogin() {
		connectedUser.addLogin("mailLog@mail.fr", mdp);
		boolean bool = connectedUser.login("mailLog@mail.fr", "aze");
		assertTrue(bool);
	}
	
	@Test
	@Ignore
	public void testLoginFail() {
		connectedUser.addLogin("mailFail@mail.fr", "aze");
		boolean bool = connectedUser.login("mailFail@mail.fr", "ae");
		assertFalse(bool);
	}

	@Test
	@Ignore
	public void testLogout() {
		connectedUser.addLogin("mailLogOut@mail.fr", "aze");
		connectedUser.login("mailLogOut@mail.fr", "aze");
		connectedUser.logout();
	}

	@Test
	@Ignore
	public void testAddLogin() {
		connectedUser.addLogin("mailAdd@mail.fr", "aze");
	}

	@Test
	@Ignore
	public void testFindLogin() {
		connectedUser.addLogin("mail@mail.fr", "aze");
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
