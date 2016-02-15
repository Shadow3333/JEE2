package monapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Entity(name = "Login")
public class Login {

	@Id()
	@Basic(optional = false)
    @Column(name = "mail", length = 200,
            nullable = false)
	private String mail;
	
	@Basic(optional = false)
    @Column(name = "pwd", length = 200,
            nullable = false)
	private String pwd;

	public Login() {
		super();
	}

	public Login(String mail, String pwd) {
		super();
		this.mail = mail;
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}
	
	
	
}
