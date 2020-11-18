package edu.ubo.minimachine.expression;

import edu.ubo.minimachine.visitor.Visitor;

public class MultiplicationExpression extends BinaryExpression {

	public MultiplicationExpression(final Expression exprLeft, final Expression exprRight) {
		super(exprLeft, exprRight);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
