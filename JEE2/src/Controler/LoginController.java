package Controler;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import monapp.services.ConnectedUser;

@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController {

    private String mail = "";
    private String pwd = "";
    @EJB
    ConnectedUser ejbUser;
    
    public String submit() {
    	boolean testlogs = ejbUser.login(mail, pwd);
    	if (testlogs) {
    		return "hello";
		}
    	else
    		System.out.println("nop");
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
	
	public String Logout(){
		ejbUser.logout();
		return "Logout";
	}
}