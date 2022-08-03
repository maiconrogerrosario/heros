package hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name ="power_stats")
public class Power   {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@Column(name="strength")
	private int  strength;
	
	@Column(name="agility")
	private int agility;
	
	@Column(name="dexterity")
	private int  dexterity;
	
	@Column(name="intelligence")
	private int intelligence;	
	
	
	
	Power() {}

	Power(int strength,int agility,int dexterity,int intelligence) {
	    this.strength = strength;
	    this.agility = agility;
	    this.dexterity = dexterity;
	    this.intelligence = intelligence;
	    
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
		return true;
		if (!(o instanceof Power))
		return false;
		Power power = (Power) o;
		return 
		Objects.equals(this.id, power.id) && 
		Objects.equals(this.strength, power.strength) && 
		Objects.equals(this.agility, power.agility) && 
		Objects.equals(this.dexterity, power.dexterity) &&
		Objects.equals(this.agility, power.agility);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.strength, this.agility, this.dexterity,this.agility);
	}

	@Override
	public String toString() {
		return "Power{" + "id=" + this.id + ", strength='" + this.strength + '\'' + ", agility='" + this.agility
			+ '\'' + ", dexterity='" + this.dexterity +", agility='" + this.agility + '\'' + '}';
	}

	

}
