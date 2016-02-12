package monapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Entity(name = "Person")
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id()
	@Basic(optional = false)
	@Column(name = "mail", length = 200,
	nullable = false, unique = true)
	private String mail;

	@Basic(optional = false)
    @Column(name = "name", length = 200,
            nullable = false)
	private String name;
	
	@Basic(optional = false)
	@Column(name = "first_name", length = 200,
	        nullable = false)
	private String firstname;
	
	@Basic()
	@Column(name = "birth_day")
	private String birth;
	
	@Basic()
	@Column(name = "web", length = 200)
	private String web;
	
	@OneToOne
	@JoinColumn(name="numCV")
	@Basic(optional = false)
	private CV cv;
	
	public Person() {
		super();
	}
	
	/**
	 * constructor
	 * @param idP
	 * @param name
	 * @param firstname
	 * @param mail
	 */
	public Person(String name, String firstname, String mail) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.mail = mail;
		this.cv = new CV();
	}
	
	/**
	 * constructor
	 * @param idP
	 * @param name
	 * @param firstname
	 * @param birth
	 * @param mail
	 * @param web
	 */
	public Person(String name, String firstname, String birth, String mail, String web, CV cv) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.birth = birth;
		this.mail = mail;
		this.web = web;
		this.cv = cv;
	}
	
	/**
	 * returns the name of a person
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of a person
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * returns the firstname of a person
	 * @return String firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * sets the firstname of a person
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * returns the birthdate of a person
	 * @return Date birth
	 */
	public String getBirth() {
		return birth;
	}
	
	/**
	 * sets the birthdate of a person
	 * @param birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/**
	 * returns the mail address of a person
	 * @return String mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * sets the mail address of a person
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * returns the website of a person
	 * @return String web
	 */
	public String getWeb() {
		return web;
	}
	
	/**
	 * sets the website of a person
	 * @param web
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * resets all information about a person in the database
	 */
	public void reset() {
		this.name = null;
		this.firstname = null;
		this.birth = null;
		this.mail = null;
		this.web = null;
	}
	
	/**
	 * creates a copy of a person already in the database
	 */
	public void copy(Person p) {
		this.name = p.getName();
		this.firstname = p.getFirstname();
		this.birth = p.getBirth();
		this.mail = p.getMail();
		this.web = p.getWeb();
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}
	
	
}
