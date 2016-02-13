package monapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Entity
public class CV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "numCV", length = 200,
	        nullable = false)
	int numCV;

	@OneToMany
	@JoinColumn(name="refActiv")
    private List<Activitie> activities;

	public CV() {
		super();
		activities = new ArrayList<>();
	}	
	
	public void addActivitie(Activitie activ)
	{
		activities.add(activ);
	}

	public int getNumCV() {
		return numCV;
	}

	public void setNumCV(int numCV) {
		this.numCV = numCV;
	}

	public List<Activitie> getActivities() {
		return activities;
	}

	public void setActivities(List<Activitie> activities) {
		this.activities = activities;
	}

}
