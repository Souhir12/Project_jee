package tn.iit.authentification.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "group_enseignant_matieres")
public class GroupeEnseignantMatiere  implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@ManyToOne
    @JoinColumn(name = "enseignant_id", referencedColumnName = "ID")
    private User enseignant_id;
	@ManyToOne
    @JoinColumn(name = "matiere_id", referencedColumnName = "ID")
    private Matiere matiere_id;
	@ManyToOne
    @JoinColumn(name = "groupe_id", referencedColumnName = "ID")
    private Groupe groupe_id;
	public User getEnseignant_id() {
		return enseignant_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Matiere getMatiere_id() {
		return matiere_id;
	}
	public void setMatiere_id(Matiere matiere_id) {
		this.matiere_id = matiere_id;
	}
	public Groupe getGroupe_id() {
		return groupe_id;
	}
	public void setGroupe_id(Groupe groupe_id) {
		this.groupe_id = groupe_id;
	}
	public void setEnseignant_id(User enseignant_id) {
		this.enseignant_id = enseignant_id;
	}
	
}
