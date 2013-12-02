package dota;

public class AbilityLevelBasedType implements Cloneable {
	protected double value;
	protected int level;
	
	public AbilityLevelBasedType() {
		super();
	}
	public AbilityLevelBasedType(final AbilityLevelBasedType o) {
		super();
		if (o == null)
			throw new NullPointerException("Cannot create a copy of 'AbilityLevelBasedType' from 'null'.");
		this.setValue(o.getValue());
		this.setLevel(o.getLevel());
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
