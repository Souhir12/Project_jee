package tn.iit.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;

public class MatiereDAO {

	public void save_update_Matiere(Matiere matiere) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(matiere);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Matiere> listMatiere() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Matiere> matieres = session.createQuery("from Matiere", Matiere.class).list();
		session.getTransaction().commit();

		return matieres;
	}

	public List<Matiere> listMatiereENS(User id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Matiere> matieres = session.createQuery("select M.id , M.label from Matiere M , GroupeEnseignantMatiere gem"
				+ " where M.id=gem.matiere_id and gem.enseignant_id = :id" ).setParameter("id", id).list();
		session.getTransaction().commit();

		return matieres;
	}

	
	public Matiere geById(int id) {
		Transaction transaction = null;
		Matiere matiere = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			matiere = (Matiere) session.createQuery("FROM Matiere G WHERE G.id = :id").setParameter("id", id)
					.uniqueResult();
			// user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return matiere;
	}

	public boolean deleteMatiere(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete a persistent object
			Matiere matiere = session.get(Matiere.class, id);
			if (matiere != null) {
				session.delete(matiere);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return true;
	}
}
