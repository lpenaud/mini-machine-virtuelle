package edu.ubo.minimachine.expression;

import edu.ubo.minimachine.Variable;
import edu.ubo.minimachine.visitor.Visitor;

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
	
	final Variable variable;

}
