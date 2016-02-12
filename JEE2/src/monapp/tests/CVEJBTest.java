package monapp.tests;

import static org.junit.Assert.*;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import monapp.model.Activitie;
import monapp.model.CV;
import monapp.services.CVEJB;

public class CVEJBTest {
	
	private static EJBContainer ejbContainer;
	private CVEJB cvEjb;
	private static CV cv;
	private static Activitie act1;
	private static Activitie act2;
	private static Set<Activitie> activities;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer();
		act1 = new Activitie("act1", "2010", "nature 1", "titre 1");
		act2 = new Activitie("act2", "2010", "nature 2", "titre 2");
		activities.add(act1);
		activities.add(act2);
		cv = new CV("cv1", activities);
	}
	
	@Before
	public void lookup() throws NamingException {
		cvEjb = (CVEJB) ejbContainer.getContext().lookup("java:global/JEE2/CVEJB");
	}

	@AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }
	
	@Test
	public void testSaveCV() {
		cvEjb.saveCV(cv);
	}

}
