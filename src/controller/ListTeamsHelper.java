package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListTeams;

public class ListTeamsHelper {

	// create a global instance of the EntityManagerFactory
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebTeamList");

	
	public void insertTeams(ListTeams toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteTeams(ListTeams toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<ListTeams> typedQuery = em.createQuery("select t from ListTeams t where t.teamName = :selectedTeamName and t.teamColors = :selectedTeamColors", ListTeams.class);

		//Substitute parameter with actual data from the toDelete player
		typedQuery.setParameter("selectedTeamName", toDelete.getTeamName());
		typedQuery.setParameter("selectedTeamColors", toDelete.getTeamColors());
		
				//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list player
		ListTeams result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateTeams(ListTeams toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListTeams> searchForTeamsByName(String teamNames) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListTeams> typedQuery = em.createQuery("select t from ListTeams t where t.team_name = :selectedTeamName", ListTeams.class);
		typedQuery.setParameter("selectedTeamName", teamNames);
		List<ListTeams> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}


	public ListTeams searchForTeamsById(int idToEdit) {
		// TODO Auto-generated method stub
		// Find by primary key
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListTeams found = em.find(ListTeams.class, idToEdit);
		em.close();
		return found;
	}


	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	public List<ListTeams> showAllTeams() {
		// TODO Auto-generated method stub
		System.out.println("~~~~~~~~~~~~showAllTeams");
		EntityManager em = emfactory.createEntityManager();
		List<ListTeams> allTeams = em.createQuery("SELECT t FROM ListTeams t").getResultList();
		System.out.println("All Teams: " + allTeams);
	
		return allTeams;
	}

}
