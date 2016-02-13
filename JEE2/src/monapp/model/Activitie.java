package monapp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Frederic and Mariana
 *
 */
@Entity
public class Activitie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "idActiv", length = 200,
	        nullable = false)
	private int idActiv;
	
	@Basic(optional = false)
	private String year;
	
	@Basic(optional = false)
	private String nature;
	
	@Basic(optional = false)
	private String titre;
	
	private String description;
	
	private String web;
	
	public Activitie() {
		super();
	}
	public Activitie( String year, String nature, String titre) {
		super();
		this.year = year;
		this.nature = nature;
		this.titre = titre;
	}
	public Activitie(String year, String nature, String titre, String description, String web) {
		super();
		this.year = year;
		this.nature = nature;
		this.titre = titre;
		this.description = description;
		this.web = web;
	}
	public int getIdActiv() {
		return idActiv;
	}
	public void setIdActiv(int idActiv) {
		this.idActiv = idActiv;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	public void cleanActivitie()
	{
		year = null;
		nature  = null;
		titre  = null;
		description  = null;
		web  = null;
	}
	

}
