package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")

public class ListTeams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAM_ID")
	private int id;
	@Column(name = "TEAM_NAME")
	private String teamName;
	@Column(name = "TEAM_COLORS")
	private String teamColors;
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name = "TEAM_ID")
	private List<ListTeam> listOfPlayers;

	public ListTeams() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListTeams(String teamName, String teamColors) {
		super();
		System.out.println("In the ListTeams Constructor.  teamName = " + teamName + " teamColors = " + teamColors);
		setTeamName(teamName);
		setTeamColors(teamColors);
	}
	
	public ListTeams(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamColors() {
		return teamColors;
	}

	public void setTeamColors(String teamColors) {
		this.teamColors = teamColors;
		
	}

	@Override
	public String toString() {
		return "ListTeams [id=" + id + ", teamName=" + teamName + ", teamColors=" + teamColors + ", listOfPlayers="
				+ listOfPlayers + "]";
	}



}
