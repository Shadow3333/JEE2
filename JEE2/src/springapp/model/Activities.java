package springapp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Activities")
public class Activities implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
@Id()
@Basic(optional = false)
@Column(name = "idActiv", length = 200,
        nullable = false)
String idActiv;


	
}
