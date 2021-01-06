package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

public class SubtractionExpression extends BinaryExpression {

	public SubtractionExpression(final Expression exprLeft, final Expression exprRight) {
		super(exprLeft, exprRight);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString("-");
	}

}
