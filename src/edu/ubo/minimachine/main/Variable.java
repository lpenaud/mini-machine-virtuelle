package edu.ubo.minimachine.main;

public class Variable {
	
	public Variable(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		if (obj instanceof Variable) {
			final Variable var = (Variable) obj;
			return var.name.equals(name);
		}
		return false;
	}

	protected final String name;
}
