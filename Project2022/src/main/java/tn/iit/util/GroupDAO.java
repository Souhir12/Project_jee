package tn.iit.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;

public class GroupDAO {

	public void save_update_Groupe(Groupe groupe) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(groupe);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public List<Groupe> listGroupeeENS(User id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Groupe> groupes = session.createQuery("select G.id , G.label ,G.nb_etd from Groupe G , GroupeEnseignantMatiere gem"
				+ " where G.id=gem.groupe_id and gem.enseignant_id = :id" ).setParameter("id", id).list();
		session.getTransaction().commit();

		return groupes;
	}
	public List<Groupe> listGroup() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Groupe> groupes = session.createQuery("from Groupe", Groupe.class).list();
		session.getTransaction().commit();

		return groupes;
	}

	public Groupe geById(int id) {
		Transaction transaction = null;
		Groupe groupe = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			groupe = (Groupe) session.createQuery("FROM Groupe G WHERE G.id = :id").setParameter("id", id)
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
		return groupe;
	}

	public boolean deleteGroupe(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete a persistent object
			Groupe groupe = session.get(Groupe.class, id);
			if (groupe != null) {
				session.delete(groupe);
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
