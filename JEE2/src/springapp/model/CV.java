package springapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CV")
public class CV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id()
	@Basic(optional = false)
	@Column(name = "numCV", length = 200,
	        nullable = false)
	String numCV;

	@OneToMany
    private Set<Activities> activities;

	public CV() {
		super();
	}

	public CV(String numCV, Set<Activities> activities) {
		super();
		this.numCV = numCV;
		this.activities = activities;
	}

	public String getNumCV() {
		return numCV;
	}

	public void setNumCV(String numCV) {
		this.numCV = numCV;
	}

	public Set<Activities> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activities> activities) {
		this.activities = activities;
	}

}
