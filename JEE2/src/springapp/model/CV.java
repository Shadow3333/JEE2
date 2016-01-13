package springapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="CV")
public class CV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "numCV", length = 200,
	        nullable = false)
	String numCV;

	@OneToMany
	@JoinColumn(name="idActiv")
    private Set<Activitie> activities;

	public CV() {
		super();
	}

	public CV(String numCV, Set<Activitie> activities) {
		super();
		this.numCV = numCV;
		this.activities = activities;
	}
	
	public void addActivities(Activitie activ)
	{
		activities.add(activ);
	}

	public String getNumCV() {
		return numCV;
	}

	public void setNumCV(String numCV) {
		this.numCV = numCV;
	}

	public Set<Activitie> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activitie> activities) {
		this.activities = activities;
	}

}
