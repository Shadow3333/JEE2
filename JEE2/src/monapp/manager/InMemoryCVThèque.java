package monapp.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import monapp.model.CV;
import monapp.model.Person;
import monapp.services.CVEJB;
import monapp.services.ConnectedUser;
import monapp.services.PersonEJB;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class InMemoryCVThèque {

	private static EJBContainer ejbContainer;
	final ConnectedUser ejbUser;
	final CVEJB ejbCV;
	final PersonEJB ejbPers;

    /**
     * constructor
     * @throws NamingException 
     */
    public InMemoryCVThèque() throws NamingException {
    	ejbUser = (ConnectedUser) ejbContainer.getContext().lookup("java:global/JEE2/ConnectedUser");
    	ejbCV = (CVEJB) ejbContainer.getContext().lookup("java:global/JEE2/CVEJB");
    	ejbPers = (PersonEJB) ejbContainer.getContext().lookup("java:global/JEE2/PersonEJB");
    }
    
    /**
     * prepares a list of people
     * return Map map
     */
    public List<CV> preparListCV()
    { 	
    	return ejbCV.getCVs();
    }
    
    /**
     * finds all groups
     */
    public List<Person> preparListPerson()
    {
    	return ejbPers.getPersons();
    }
}
