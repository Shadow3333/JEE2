package monapp.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import monapp.services.CVEJB;
import monapp.services.ConnectedUser;
import monapp.services.PersonEJB;

/**
 * 
 * @author Frederic and Livia
 *
 */
public class InMemoryCVThèque {

	final ConnectedUser ejbUser;
	final CVEJB ejbCV;
	final PersonEJB ejbPers;

    /**
     * constructor
     */
    public InMemoryCVThèque() {
    	ejbUser = new ConnectedUser();
    	ejbCV = new CVEJB();
    	ejbPers = new PersonEJB();
    }
    
    /**
     * prepares a list of people
     * return Map map
     */
    public Map<String, List<Person>> preparList()
    {
    	Map<String, List<Person>> map = new HashMap<String, List<Person>>();
    	List<Group> listGr = DAO_gp.findAllGroups();
    	if (listGr.isEmpty()) {
			return null;
		}
    	
    	for (Group group : listGr) {
    		map.put(group.getNameGr(), DAO_pers.findByGroup(group.getNameGr()));
		}
    	
    	return map;
    }
    
    /**
     * finds all groups
     */
    public List<Group> findAllGroups()
    {
    	return DAO_gp.findAllGroups();
    }

    /**
     * finds a person by id
     */
    public Person findPerson(Integer idP) {
		return DAO_pers.findPerson(idP);
	}
    
    /**
     * saves a Person bean in the database
     */
    public void savePers(Person p) {
		DAO_pers.savePerson(p);
	}

    /**
     * 
     */
	public Person authPers(String mail, String pwd) {
		return DAO_pers.auth(mail, pwd);
	}
	
	/**
	 * checks the mail address
	 */
	public Boolean checkMail(String mail) {
		return DAO_pers.checkMail(mail);
	}
	
	/**
	 * returns the link associated to a mail address
	 * return Link link
	 */
	public Link getLink(String mail) {
		return DAO_link.getLink(mail);
	}
	
	/**
	 * 
	 */
	public Link getMail(String link) {
		return DAO_link.getMail(link);
	}
	
	/**
	 * saves a link into the database
	 * return Link link
	 */
	public Link addLink(Link l) {
		return DAO_link.addLink(l);
	}
	
	/**
	 * finds the person associated to a mail address
	 * return Person person
	 */
	public Person findByMail(String mail) {
		return DAO_pers.findByMail(mail);
	}
	
	/**
	 * deletes a link into the database
	 * return true if the link was successfully deleted, false otherwise
	 */
	public Boolean deleteLink(String mail) {
		return DAO_link.deleteLink(mail);
	}
	
	/**
	 * saves a group into the database
	 * return Group group
	 */
	public Group addGroup(Group gr) {
		return DAO_gp.addGroup(gr);
	}
}
