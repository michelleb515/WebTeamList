package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="players")

public class ListTeam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="ID")
	private int id; 
	@Column(name = "NAME")
	private String name; 
	@Column(name = "JERSEY")
	private int jersey; 
	@Column(name = "WEIGHT")
	private int weight;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "TEAM_ID")
	private ListTeams listofTeams;

	
	public ListTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListTeam(String name, int jersey, int weight, ListTeams listofTeams) {
		super();
		this.name = name;
		this.jersey = jersey;
		this.weight = weight;
		this.listofTeams = listofTeams; 
	}
	public int getId() {
		//System.out.println("ID = " + id);
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJersey() {
		return jersey;
	}
	public void setJersey(int jersey) {
		this.jersey = jersey;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ListTeams getTeamId() {
		return listofTeams;
	}
	public void setTeamId(ListTeams listofTeams) {
		this.listofTeams = listofTeams;
	}
	@Override
	public String toString() {
		return "ListTeam [id=" + id + ", name=" + name + ", jersey=" + jersey + ", weight=" + weight + ", Team = "
				+ listofTeams + "]";
	}
	public String returnPlayerDetails() {
		// TODO Auto-generated method stub
		return "id=" + id + ", name=" + name + ", jersey=" + jersey + ", weight=" + weight + ", Team = " + listofTeams;
	}
	
	

}
