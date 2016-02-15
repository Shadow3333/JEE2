package monapp.Controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import monapp.model.Activitie;
import monapp.services.ConnectedUser;
import monapp.utilitaire.nature;

@ManagedBean(name = "MyActivitiesController")
@ViewScoped
public class MyActivitiesController implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    private Activitie activ = new Activitie();
    List<Activitie> activities = new ArrayList<Activitie>();
    Activitie TheActivitie;
    @EJB
    ConnectedUser ejbUser;

    public MyActivitiesController() {
    }
    
    public List<Activitie> ListActivities()
    {
    	return activities;
    }
    
    public List<Activitie> getActivities() {
        return activities;
    }

    public void addActivities() {
    	activities.add(activ);
    	ejbUser.addActivitie(activ);
        activ = new Activitie();
    }
    
    public List<String> getNatures()
    {
    	List<String> myList = new ArrayList<String>();
    	for (nature nature : nature.values()) {
			myList.add(nature.toString());
		}
    	return myList;
    }

    public Activitie getActiv() {
        return activ;
    }

    public void setActivitie(Activitie activ) {
        this.activ = activ;
    }
    
    public int getSize()
    {
    	activities = ConnectedUser.getCurrUser().getCv().getActivities();
    	return activities.size();
    }
    
    public String goToActivitie(Activitie activitie)
    {
    	TheActivitie = activitie;
    	return "editMyActivitie";
    }
    
    public void removeActivitie(Activitie activitie)
    {
    	activities.remove(activitie);
    	ejbUser.removeActivitie(activ);
    }
    
    public void majActivitie(Activitie activitie)
    {
    	ejbUser.majActivitie(activitie);
    }
    
}