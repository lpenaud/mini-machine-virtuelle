package edu.ubo.minimachine.main.expression;

import edu.ubo.minimachine.main.visitor.Visitor;

public class AdditionExpression extends BinaryExpression {

	public AdditionExpression(final Expression exprLeft, final Expression exprRight) {
		super(exprLeft, exprRight);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
