package monapp.Controler;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import monapp.services.ConnectedUser;

/**
 * 
 * @author Frederic and Mariana
 *
 */
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
    		reset();
    		return "hello";
		}
        return null;
    }
    
    public void reset()
    {
    	mail = "";
    	pwd = "";
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