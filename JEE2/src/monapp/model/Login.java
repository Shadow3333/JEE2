package monapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "login")
public class Login {

	@Id
    @Column(name = "mail", length = 200)
	private String mail;
	
    @Column(name = "password", length = 200)
	private String pwd;

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
