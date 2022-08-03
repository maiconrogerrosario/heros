package hero;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToOne;




@Entity
@Table(name ="hero")
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	@Column(name="name") 
	private String name;
	
	@Column(name="race")
	private String race;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@ManyToOne  private Power power_stats;

	
	
	public Power getPower_stats() {
		return power_stats;
	}



	public void setPower_stats(Power power_stats) {
		this.power_stats = power_stats;
	}

	Hero(){}

	Hero(String name, String race, boolean enabled, Power power_stats) {

	    this.name = name;
	    this.race = race;
	    this.power_stats = power_stats; 
	    this.enabled = enabled;
	  
	}
	
	
	Hero(Hero hero, Power power_stats) {

	    this.name = hero.getName();
	    this.race = hero.getRace();
	    this.power_stats = power_stats; 
	    this.enabled = true;
	  
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}



	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String compareHero(Hero hero1, Hero hero2) {
			 

		  String strength = null;
		  String dexterity = null;
		  String agility = null;
		  String intelligence = null;
			  
		 if (hero1.getPower_stats().getStrength()>hero2.getPower_stats().getStrength()) {
			 strength =  "Strength:{" + "id=" + hero1.getId()  +" "+ "+" +hero1.getPower_stats().getStrength()  + 
				  ","	+ "id=" + hero2.getId() + " " + "-"+hero2.getPower_stats().getStrength()  + '}';		
					 
		 } else {
			  strength =  "Strength:{" + "id=" + hero1.getId()  +" " + "-" +hero1.getPower_stats().getStrength()  + 
					  ","	+ "id=" + hero2.getId() + " " + "+" + hero2.getPower_stats().getStrength()  + '}';	
			 
			 
		 }
		 
		 if (hero1.getPower_stats().getStrength()>hero2.getPower_stats().getStrength()) {
			 dexterity =  "Dexterity:{" + "id=" + hero1.getId()  +" "+ "+" +hero1.getPower_stats().getDexterity()  + 
				  ","	+ "id=" + hero2.getId() + " " + "-"+hero2.getPower_stats().getDexterity()  + '}';		
					 
		 } else {
			 dexterity =  "Dexterity:{" + "id=" + hero1.getId()  +" " + "-" +hero1.getPower_stats().getDexterity()  + 
					  ","	+ "id=" + hero2.getId() + " " + "+" + hero2.getPower_stats().getDexterity()  + '}';	
			 
			 
		 }
		 
		 if (hero1.getPower_stats().getStrength()>hero2.getPower_stats().getStrength()) {
			 agility =  "Agility:{" + "id=" + hero1.getId()  +" "+ "+" +hero1.getPower_stats().getAgility()  + 
				  ","	+ "id=" + hero2.getId() + " " + "-"+hero2.getPower_stats().getAgility()  + '}';		
					 
		 } else {
			 agility =  "Agility:{" + "id=" + hero1.getId()  +" " + "-" +hero1.getPower_stats().getAgility()  + 
					  ","	+ "id=" + hero2.getId() + " " + "+" + hero2.getPower_stats().getAgility()  + '}';	
				 
		 }
		 
		 if (hero1.getPower_stats().getStrength()>hero2.getPower_stats().getStrength()) {
			 intelligence =  "Intelligence:{" + "id=" + hero1.getId()  +" "+ "+" +hero1.getPower_stats().getIntelligence()  + 
				  ","	+ "id=" + hero2.getId() + " " + "-"+hero2.getPower_stats().getIntelligence()  + '}';		
					 
		 } else {
			 intelligence =  "Intelligence:{" + "id=" + hero1.getId()  +" " + "-" +hero1.getPower_stats().getIntelligence()  + 
					  ","	+ "id=" + hero2.getId() + " " + "+" + hero2.getPower_stats().getIntelligence()  + '}';			 
		 }
		 
		 
	 
		 
		 return "compareHero:{" + strength + "," + agility  + ","  +  dexterity + ","  +   intelligence + "}";
		 
		 
			
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
		return true;
		if (!(o instanceof Hero))
		return false;
		Hero hero = (Hero) o;
		return 
		Objects.equals(id, hero.id) && 
		Objects.equals(name, hero.name) && 
		Objects.equals(race, hero.race) && 
		Objects.equals(power_stats, hero.power_stats) &&
		Objects.equals(enabled, hero.enabled);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.race, this.power_stats,this.enabled);
	}

	@Override
	public String toString() {
		return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", race='" + race
			+ '\'' + ", power_stats_id='" + power_stats.getId() + power_stats.getStrength() + power_stats.getAgility() + power_stats.getDexterity() +", enabled='" + enabled + '\'' + '}';
	}
	
	
	
}