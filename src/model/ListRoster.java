package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "roster")

public class ListRoster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROSTER_ID")
	private int rosterId;

	//@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID")
	private List<ListTeams> listOfTeams;

	public ListRoster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListRoster(ListTeams teams, List<ListTeams> listOfTeams) {
		super();
		//this.teams = teams;
		this.listOfTeams = listOfTeams;
	}

	public int getRosterId() {
		return rosterId;
	}

	public void setRosterId(int rosterId) {
		this.rosterId = rosterId;
	}

	//public ListTeams getTeams() {
		//return teams;
	//}

	//public void setTeams(ListTeams teams) {
		//this.teams = teams;
	//}

	public List<ListTeams> getListOfTeams() {
		return listOfTeams;
	}

	public void setListOfTeams(List<ListTeams> listOfTeams) {
		this.listOfTeams = listOfTeams;
	}

	@Override
	public String toString() {
		return "ListRoster [rosterId=" + rosterId + ", listOfTeams=" + listOfTeams + "]";
	}

	

	
}
