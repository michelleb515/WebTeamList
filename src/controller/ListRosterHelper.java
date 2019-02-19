package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListRoster;

public class ListRosterHelper {
	
	
	// create a global instance of the EntityManagerFactory
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebTeamList");

	
	public void insertRoster(ListRoster toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteRoster(ListRoster toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<ListRoster> typedQuery = em.createQuery("select t from ListRoster t where t.name = :selectedName and t.jersey = :selectedJersey", ListRoster.class);

		//Substitute parameter with actual data from the toDelete Roster
		//typedQuery.setParameter("selectedTeamId", toDelete.getTeamId());
		//typedQuery.setParameter("selectedPlayerId", toDelete.getPlayerId());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list Roster
		ListRoster result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateRoster(ListRoster toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

//	public List<ListRoster> searchForRosterByName(String RosterName) {
//		// TODO Auto-generated method stub
		///EntityManager em = emfactory.createEntityManager();
		//em.getTransaction().begin();
		//TypedQuery<ListTeam> typedQuery = em.createQuery("select t from ListRoster t where t.name = :selectedName", ListRoster.class);
		//typedQuery.setParameter("selectedName", playerName);
		//List<ListRoster> foundPlayers = typedQuery.getResultList();
		//em.close();
		//return foundPlayers;
	//}


	public ListRoster searchForRosterById(int idToEdit) {
		// TODO Auto-generated method stub
		// Find by primary key
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListRoster found = em.find(ListRoster.class, idToEdit);
		em.close();
		return found;
	}


	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	public List<ListRoster> showAllRosters() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		//List<ListRoster> allRosters = em.createQuery("SELECT t FROM ListRoster t").getResultList()
		System.out.println("~~~~~ Creating query");
		List<ListRoster> allRosters = em.createQuery("SELECT t FROM ListRoster t").getResultList();
		
		return allRosters;
	}

}
