package monapp.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.validation.constraints.AssertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	private static List<Activitie> activities;
	
	@BeforeClass
	public static void init(){
		ejbContainer = EJBContainer.createEJBContainer();
		activities = new ArrayList<>();
		act1 = new Activitie("2010", "nature 1", "titre 1");
		act2 = new Activitie("2010", "nature 2", "titre 2");
		activities.add(act1);
		activities.add(act2);
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
	
	@Ignore
	@Test
	public void testaddCV() 
	{
		cv = new CV();
		cvEjb.addCV(cv);
	}
	
	@Test
	public void testSaveCVwithActivities()
	{
		cv = new CV();
		cvEjb.saveActivitie(act1);
		cv.addActivitie(act1);
//		cvEjb.addCV(cv);
//		cv.setActivities(activities);
		cvEjb.saveCV(cv);
	}
	
	@Ignore
	@Test
	public void testGetCVs() {
		List<CV> l = cvEjb.getCVs();
		assertNotNull(l);
		assertTrue(l.contains(cv));
	}

}
