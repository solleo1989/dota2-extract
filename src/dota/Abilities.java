package dota;

import java.util.ArrayList;
import java.util.List;

public class Abilities implements Cloneable {
	private List<Ability> abilities;
	
	public Abilities() {
		super();
	}
	public Abilities(final Abilities o) {
		if (o == null)
			throw new NullPointerException("Can't copy from a null Abilities object");
		if (o.getAbilities() != null)
			this.copyAbilities(o.getAbilities());
			
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	public void copyAbilities(List<Ability> abilities) {
		this.abilities = new ArrayList<Ability>();
		for (Ability o : abilities)
			this.abilities.add(new Ability(o));
	}
	
}
