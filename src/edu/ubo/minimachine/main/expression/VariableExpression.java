package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.Variable;
import edu.ubo.minimachine.main.visitor.Visitor;

public class VariableExpression implements UnaryExpression {
	
	public VariableExpression(final Variable variable) {
		this.variable = variable;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public Variable getVariable() {
		return variable;
	}
	
	@Override
	public String toString() {
		return variable.getName();
	}
	
	final Variable variable;

}
