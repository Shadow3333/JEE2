package monapp.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import monapp.model.Activitie;

@ManagedBean
@ViewScoped
public class AjaxBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    private Activitie activ = new Activitie();
    
    List<Activitie> activities = new ArrayList<Activitie>();

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

    public AjaxBean() {
    }

    public Activitie getActiv() {
        return activ;
    }

    public void setActivitie(Activitie activ) {
        this.activ = activ;
    }

}