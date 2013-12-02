package dota;

public class AbilitySpecial implements Cloneable {
	private String type;
	private String value;
	private String level;
	
	public AbilitySpecial() {
		super();
	}
	public AbilitySpecial(final AbilitySpecial o) {
		super();
		if (o == null)
			throw new NullPointerException("Cannot create a copy of 'AbilitySpecial' from 'null'.");
		this.setType(o.getType());
		this.setValue(o.getValue());
		this.setLevel(o.getLevel());
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
