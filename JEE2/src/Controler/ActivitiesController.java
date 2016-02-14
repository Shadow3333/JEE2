package Controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import monapp.model.Activitie;
import monapp.services.ConnectedUser;

@ManagedBean
@ViewScoped
public class ActivitiesController implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    private Activitie activ = new Activitie();
    List<Activitie> activities = new ArrayList<Activitie>();
    @EJB
    ConnectedUser ejbUser;
    
    public ActivitiesController() {
    	init();
    }
    
    public void init()
    {
    	if (ejbUser.getCurrUser() == (null)) {
    		System.out.println("pas d'user");
		}
    	System.out.println(ejbUser.getCurrUser().getMail());
    	activities = ejbUser.getCurrUser().getCv().getActivities();
    }
    
    public List<Activitie> getActivities() {
        return activities;
    }

    public void setCities(List<Activitie> activities) {
        this.activities = activities;
    }

    public void addActivities() {
    	activities.add(activ);
        activ = new Activitie();
    }

    public void removeCity(int index) {
        activities.remove(index);
    }

    public Activitie getActiv() {
        return activ;
    }

    public void setActivitie(Activitie activ) {
        this.activ = activ;
    }

}