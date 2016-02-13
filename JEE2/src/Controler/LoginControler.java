package Controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "LoginControler")
@SessionScoped
public class LoginControler {

    private String mail = "";
    private String pwd = "";

    public String submit() {
        System.out.println("LOG: Submit");
        return null;
    }
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}