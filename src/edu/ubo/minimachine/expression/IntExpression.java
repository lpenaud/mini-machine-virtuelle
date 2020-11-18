package edu.ubo.minimachine.expression;

import edu.ubo.minimachine.visitor.Visitor;

public class IntExpression implements UnaryExpression {
	public IntExpression(final int value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public int getValue() {
		return value;
	}

	protected final int value;
}
