package Controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import monapp.model.Activitie;
import monapp.services.CVEJB;
import monapp.services.ConnectedUser;

@ManagedBean
@ViewScoped
public class ActivitiesController implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    private Activitie activ = new Activitie();
    List<Activitie> activities = new ArrayList<Activitie>();
    @EJB
    ConnectedUser ejbUser;
    @EJB
    CVEJB ejbCV;
    
    public ActivitiesController() {
    }
    
    public List<Activitie> creatListActivities()
    {
    	activities = ejbUser.getCurrUser().getCv().getActivities();
    	return activities;
    }
    
    public List<Activitie> getActivities() {
        return activities;
    }

    public void setCities(List<Activitie> activities) {
        this.activities = activities;
    }

    public void addActivities() {
    	activities.add(activ);
    	System.out.println(ejbUser.getCurrUser());
    	ejbUser.getCurrUser().getCv().addActivitie(activ);
    	ejbCV.saveCV(ejbUser.getCurrUser().getCv());
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