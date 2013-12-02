package dota;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;



public class Ability implements Cloneable {
	
	/**
	 * Contents
	 */
    protected String name;		// name of the ability
    protected String type;		// type of the ability 
    protected String behavior;	//
    protected List<AbilityLevelBasedType> castRange;
    protected List<AbilityLevelBasedType> channelTime;
    protected List<AbilityLevelBasedType> coolDown;
    protected List<AbilityLevelBasedType> duration;
    protected List<AbilityLevelBasedType> damage;
    protected List<AbilityLevelBasedType> manaCost;
    protected List<AbilitySpecial> special;
    protected Integer id;
	
    
    public Ability() {
    	super();
    }
    /**
     * Copy constructor
     */
    public Ability(Ability o) {
    	super();
    	if (o == null) 
    		throw new NullPointerException("This ability is a null pointer");
    	this.name = (o.name == null)? null : o.getName();
    	this.type = (o.type == null)? null : o.getType();
    	this.behavior = (o.behavior == null)? null : o.getBehavior();
    	if (o.getCastRange() != null) {
    		this.copyCastRange(o.getCastRange());
    	}
		if (o.getChannelTime() != null) {
			this.copyChannelTime(o.getChannelTime());
		}
		if (o.getCoolDown() != null) {
			this.copyCoolDown(o.getCoolDown());
		}
		if (o.getDuration() != null) {
			this.copyDuration(o.getDuration());
		}
		if (o.getDamage() != null) {
			this.copyDamage(o.getDamage());
		}
		if (o.getManaCost() != null) {
			this.copyManacost(o.getManaCost());
		}
		if (o.getSpecial() != null) {
			this.copySpecial(o.getSpecial());
		}
		// CBuiltinLeafInfo: java.lang.Integer
		this.setId(((o.getId() == null)? null : o.getId()));	
    }
    
	// String name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// String type
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	// String behavior
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	// List<AbilityLevelBasedType> castRange
	public List<AbilityLevelBasedType> getCastRange() {
		return castRange;
	}
	public void setCastRange(List<AbilityLevelBasedType> castRange) {
		this.castRange = castRange;
	}
	public void copyCastRange(List<AbilityLevelBasedType> castRange) {
		this.castRange = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : castRange)
			this.castRange.add(new AbilityLevelBasedType(t));
	}
	// List<AbilityLevelBasedType> channelTime
	public List<AbilityLevelBasedType> getChannelTime() {
		return channelTime;
	}
	public void setChannelTime(List<AbilityLevelBasedType> channelTime) {
		this.channelTime = channelTime;
	}
	public void copyChannelTime(List<AbilityLevelBasedType> channelTime) {
		this.channelTime = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : channelTime)
			this.channelTime.add(new AbilityLevelBasedType(t));
	}
	// List<AbilityLevelBasedType> coolDown
	public List<AbilityLevelBasedType> getCoolDown() {
		return coolDown;
	}
	public void setCoolDown(List<AbilityLevelBasedType> coolDown) {
		this.coolDown = coolDown;
	}
	public void copyCoolDown(List<AbilityLevelBasedType> coolDown) {
		this.coolDown = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : coolDown)
			this.coolDown.add(new AbilityLevelBasedType(t));
	}
	// List<AbilityLevelBasedType> duration
	public List<AbilityLevelBasedType> getDuration() {
		return duration;
	}
	public void setDuration(List<AbilityLevelBasedType> duration) {
		this.duration = duration;
	}
	public void copyDuration(List<AbilityLevelBasedType> duration) {
		this.duration = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : duration)
			this.duration.add(new AbilityLevelBasedType(t));
	}
	// List<AbilityLevelBasedType> damage
	public List<AbilityLevelBasedType> getDamage() {
		return damage;
	}
	public void setDamage(List<AbilityLevelBasedType> damage) {
		this.damage = damage;
	}
	public void copyDamage(List<AbilityLevelBasedType> damage) {
		this.damage = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : damage)
			this.damage.add(new AbilityLevelBasedType(t));
	}
	// List<AbilityLevelBasedType> manaCost
	public List<AbilityLevelBasedType> getManaCost() {
		return manaCost;
	}
	public void setManaCost(List<AbilityLevelBasedType> manaCost) {
		this.manaCost = manaCost;
	}
	public void copyManacost(List<AbilityLevelBasedType> manaCost) {
		this.manaCost = new ArrayList<AbilityLevelBasedType>();
		for (AbilityLevelBasedType t : manaCost)
			this.manaCost.add(new AbilityLevelBasedType(t));
	}
	// List<AbilitySpecial> special
	public List<AbilitySpecial> getSpecial() {
		return special;
	}
	public void setSpecial(List<AbilitySpecial> special) {
		this.special = special;
	}
	public void copySpecial(List<AbilitySpecial> special) {
		this.special = new ArrayList<AbilitySpecial>();
		for (AbilitySpecial t : special)
			this.special.add(new AbilitySpecial(t));
	}
	// Integer id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
