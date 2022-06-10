package tn.iit.authentification.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cours")
public class Cour implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	 @Column(name = "filename")
	    private String filename;	
	 
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date created_date;
    
    @Column(name = "tirage_date")
    public String tirage_date;
    
    @Column(name = "nb_copie")
    public int nb_copie;
    
 
	public int getNb_copie() {
		return nb_copie;
	}

	public void setNb_copie(int nb_copie) {
		this.nb_copie = nb_copie;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@ManyToOne
    @JoinColumn(name = "gem_id", referencedColumnName = "ID")
    private GroupeEnseignantMatiere gem_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getCreated_date() {
		return (Timestamp) created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date =  created_date;
	}

	public String getTirage_date() {
		return tirage_date;
	}

	public void setTirage_date(String tirage_date) {
		this.tirage_date =  tirage_date;
	}

	public GroupeEnseignantMatiere getGem_id() {
		return gem_id;
	}

	public void setGem_id(GroupeEnseignantMatiere gem_id) {
		this.gem_id = gem_id;
	}

 
}
