package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

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
