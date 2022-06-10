package tn.iit.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.iit.authentification.model.Cour;
import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.User;
import tn.iit.authentification.model.GroupeEnseignantMatiere;
public class CourDAO {

	public void save_update_Cour(Cour cour) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(cour);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Cour> listCour() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Cour> cours = session.createQuery("select u.firstName , u.lastName ,c.filename,c.created_date,c.tirage_date,g.label as nameg , m.label as mat ,c.id as idg from Cour c ,User u,Groupe g,Matiere m ,GroupeEnseignantMatiere gem where gem.enseignant_id=u.id and gem.groupe_id=g.id and gem.matiere_id=m.id and gem.id=c.gem_id").list();
		session.getTransaction().commit();

		return cours;
	}
	
	public  List<GroupeEnseignantMatiere> valide_nb_etd(int id) {
		Transaction transaction = null;
		List<GroupeEnseignantMatiere> cours = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			 cours = (List<GroupeEnseignantMatiere>) session.createQuery(" from GroupeEnseignantMatiere gem where gem.id=:id").setParameter("id", id).list();

			// user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cours;
		
	}

	public Cour geById(int id) {
		Transaction transaction = null;
		Cour cour = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			cour = (Cour) session.createQuery("FROM Cour G WHERE G.id = :id").setParameter("id", id).uniqueResult();
			// user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cour;
	}

	public boolean deleteCour(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete a persistent object
			Cour cour = session.get(Cour.class, id);
			if (cour != null) {
				session.delete(cour);
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
